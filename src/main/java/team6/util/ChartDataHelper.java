package team6.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.domain.Sort;

import team6.models.Query;
import team6.util.ChartData;
import team6.util.parameters.GroupParameter;
import team6.util.parameters.JoinParameter;
import team6.util.parameters.SelectParameter;
import team6.util.parameters.SortParameter;
import team6.util.parameters.WhereParameter;


public class ChartDataHelper {

	public static ChartData dataFromQuery(ArrayList<Query> queryList) {
		ArrayList<String> labelList = new ArrayList<>();
		ArrayList<String> sourceList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> datasetList = new ArrayList<>();
		

		for (Query query : queryList) {
			sourceList.add(query.getName());

			HashMap<String, String> nameValueMap = new HashMap<>();
			String queryString = query.getQueryString();
			String[] parameterList = queryString.split("&");
			for (String parameter : parameterList) {
				String[] nameValuePair = parameter.split("=");
				nameValueMap.put(nameValuePair[0], nameValuePair[1]);
			}
			String sortBy;
			if (nameValueMap.containsKey("sort")) {
				sortBy = nameValueMap.get("sort");
			} else {
				sortBy = "id";
			}
			String sortDirection;
			if (nameValueMap.containsKey("sortDirection")) {
				sortBy = nameValueMap.get("sortDirection");
			} else {
				sortBy = "asc";
			}
			final Sort sortObj = SortParameter.parse(sortBy, sortDirection);
			if (nameValueMap.containsKey("join")) {
            			final String[] joinEntities = JoinParameter.parse(nameValueMap.get("join"));
            			ArrayList<ArrayList<Object>> allRows = new ArrayList<>();
            			allRows.add(repository.findAll(sortObj));
            			int i = 1;
            			for (String entity : joinEntities) {
                			entityNameToIndex.put(entity, i++);
               				final JpaRepository otherRepository = getRepo(entity);
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
		}
		ChartData data = new ChartData();
		return data;
	}
}