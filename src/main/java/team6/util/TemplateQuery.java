package team6.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import team6.factories.TemplateFactoryWrapper;
import team6.models.Template;
import team6.util.expressions.BooleanExpression;

public class TemplateQuery {
    private String entityName;
    private Map<String, String> entityAttributeToFriendlyNameMap;
    private List<String> attributeNames;
    private List<String> friendlyNames;
    private Map<String, JpaRepository> entityNameToRepository;
    private JpaRepository repository;

    public TemplateQuery(
        String entityName,
        Map<String, String> entityAttributeToFriendlyNameMap,
        List<String> attributeNames,
        List<String> friendlyNames,
        Map<String, JpaRepository> entityNameToRepository
    ) {
        this.entityName = entityName;
        this.entityAttributeToFriendlyNameMap = entityAttributeToFriendlyNameMap;
        this.attributeNames = attributeNames;
        this.friendlyNames = friendlyNames;
        this.entityNameToRepository = entityNameToRepository;
        this.repository = entityNameToRepository.get(entityName);
    }

    public Table execute(Sort sortObj, String[] joinEntities,
        List<String> select, BooleanExpression where, String groupBy) {
        final Map<String, String> attributeToFriendlyNameMap = new HashMap<>();
        final Map<String, Integer> entityNameToIndex = new HashMap<>();
        List<Attribute> attributes = new ArrayList<>();
        List<List<Object>> joinedRows;
        entityNameToIndex.put(entityName, 0);
        if (joinEntities != null) {
            List<List<Object>> allRows = new ArrayList<>();
            allRows.add(repository.findAll(sortObj));
            int i = 1;
            for (String entity : joinEntities) {
                entityNameToIndex.put(entity, i++);
                final JpaRepository otherRepository = this.entityNameToRepository.get(entity);
                final Template otherTemplate = new TemplateFactoryWrapper().build(entity, new HashMap<>(), null);
                final List<Object> otherRows = otherRepository.findAll();
                attributeToFriendlyNameMap.putAll(otherTemplate.getAttributeToFriendlyNameMap());
                List<String> selectAttributes = otherTemplate.getAttributeNames()
                    .stream()
                    .map(attributeName -> entity + "." + attributeName)
                    .collect(Collectors.toList());
                attributeNames.addAll(selectAttributes);
                friendlyNames.addAll(otherTemplate.getFriendlyNames());
                allRows.add(otherRows);
            }
            joinedRows = CartesianProduct.evaluate(allRows);
        } else {
            final List<Object> rows = repository.findAll(sortObj);
            joinedRows = rows.stream()
                .map(row -> {
                    List<Object> rowInList = new ArrayList<>();
                    rowInList.add(row);
                    return rowInList;
                })
                .collect(Collectors.toList());
        }
        attributeToFriendlyNameMap.putAll(entityAttributeToFriendlyNameMap);
        if (select != null) {
            attributeNames = select;
            friendlyNames = attributeNames.stream()
                .map(attributeName -> attributeToFriendlyNameMap.get(attributeName.replaceFirst("(.+\\.)?", "")))
                .collect(Collectors.toList());
        }

        attributes = attributeNames.stream()
            .map(attributeName -> {
                final String[] defaultedAttributeName = getEntityAndAttributeName(attributeName, entityName);
                return new Attribute(entityNameToIndex.get(defaultedAttributeName[0]), defaultedAttributeName[1]);
            })
            .collect(Collectors.toList());
        List<List<Object>> filteredJoinedRows;
        if (where != null) {
            filteredJoinedRows = joinedRows.stream()
                .filter(joinedRow -> {
                    final BooleanExpression expression = where.clone();
                    expression.populateWithObject(joinedRow.get(0));
                    for (Object object : joinedRow) {
                        expression.populateWithObject(object, object.getClass().getSimpleName() + ".");
                    }
                    return expression.isTrue();
                })
                .collect(Collectors.toList());
        } else {
            filteredJoinedRows = joinedRows;
        }
        List<List<List<Object>>> groupedFilteredJoinedRows;
        if (groupBy != null) {
            final String[] defaultedGroupBy = getEntityAndAttributeName(groupBy, entityName);
            final HashMap<Object, List<List<Object>>> rowGroupsMap = new HashMap<>();
            filteredJoinedRows.forEach(row -> {
                final Object attribute = AttributeResolver.get(defaultedGroupBy[1], row.get(entityNameToIndex.get(defaultedGroupBy[0])));
                final List<List<Object>> rowGroup = rowGroupsMap.getOrDefault(attribute, new ArrayList<>());
                rowGroup.add(row);
                rowGroupsMap.put(attribute, rowGroup);
            });
            groupedFilteredJoinedRows = new ArrayList<>(rowGroupsMap.values());
        } else {
            List<List<Object>> rowGroup = new ArrayList<>();
            filteredJoinedRows.forEach(rowGroup::add);
            groupedFilteredJoinedRows = new ArrayList<>();
            groupedFilteredJoinedRows.add(rowGroup);
        }
        return new Table(attributes, groupedFilteredJoinedRows);
    }

    private String[] getEntityAndAttributeName(String entityAndName, String defaultEntityName) {
        String[] entityAndNameArr = entityAndName.split("\\.");
        if (entityAndNameArr.length == 1) {
            final String entityName = defaultEntityName;
            final String attributeName = entityAndNameArr[0];
            return new String[]{entityName, attributeName};
        } else if (entityAndNameArr.length == 2) {
            final String entityName = entityAndNameArr[0];
            final String attributeName = entityAndNameArr[1];
            return new String[]{entityName, attributeName};
        } else {
            throw new IllegalArgumentException();
        }
    }

    public class Table {
        public List<Attribute> attributes;
        public List<List<List<Object>>> data;
    
        public Table(List<Attribute> attributes, List<List<List<Object>>> data) {
            this.attributes = attributes;
            this.data = data;
        }
    }
    
    public class Attribute {
        public Integer entityIndex;
        public String name;
    
        public Attribute(Integer entityIndex, String name) {
            this.entityIndex = entityIndex;
            this.name = name;
        }
    }
    
}