package team6.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import team6.factories.TemplateFactoryWrapper;
import team6.models.Chart;
import team6.models.ChartQuery;
import team6.models.Query;
import team6.models.Template;
import team6.repositories.ChartQueryRepository;
import team6.repositories.ChartRepository;
import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.CommunityConnectionsTemplateRepository;
import team6.repositories.EmploymentTemplateRepository;
import team6.repositories.InformationAndOrientationTemplateRepository;
import team6.repositories.LTClientEnrolTemplateRepository;
import team6.repositories.LTClientExitTemplateRepository;
import team6.repositories.LTCourseSetupTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.repositories.QueryRepository;
import team6.throwables.ChartNotFoundException;
import team6.util.AttributeResolver;
import team6.util.TemplateQuery;
import team6.util.parameters.GroupParameter;
import team6.util.parameters.JoinParameter;
import team6.util.parameters.SelectParameter;
import team6.util.parameters.SortParameter;
import team6.util.parameters.WhereParameter;

@Controller
public class ChartController {
    @Autowired
    private NARsTemplateRepository narsTemplateRepository;
    @Autowired
    private ClientProfileTemplateRepository clientProfileTemplateRepository;
    @Autowired
    private CommunityConnectionsTemplateRepository communityConnectionsTemplateRepository;
    @Autowired
    private EmploymentTemplateRepository employmentTemplateRepository;
    @Autowired
    private InformationAndOrientationTemplateRepository informationAndOrientationTemplateRepository;
    @Autowired
    private LTClientEnrolTemplateRepository ltClientEnrolTemplateRepository;
    @Autowired
    private LTCourseSetupTemplateRepository ltCourseSetupTemplateRepository;
    @Autowired
	private LTClientExitTemplateRepository ltClientExitTemplateRepository;
	
	@Autowired
	private QueryRepository queryRepository;
	@Autowired
	private ChartRepository chartRepository;
	@Autowired
	private ChartQueryRepository chartQueryRepository;

	@GetMapping("/charts")
    public String readAllView(Model model) {
        Iterable<Chart> charts = chartRepository.findAll();
        model.addAttribute("charts", charts);
        return "charts/read-list";
    }

	@GetMapping("/charts/{id}/embed")
    public String readByIdView(@PathVariable String id, Model model) {
        try {
            Long chartId = Long.parseLong(id);
            Optional<Chart> chart = chartRepository.findById(chartId);
            addChartAttributes(model, chart.get());
            return "charts/embed";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

	private void addChartAttributes(Model model, Chart chart) {
		try {
			List<String> sourceLabels = new ArrayList<>();
			List<TemplateQuery.Table> tables = new ArrayList<>();
			List<Integer[]> data = new ArrayList<>();
			List<String> labels = new ArrayList<>();

			List<ChartQuery> chartQueries = chart.getChartQueries().stream()
				.sorted((c1, c2) -> {
					String c1Name = c1.getQuery().getName();
					String c2Name = c2.getQuery().getName();
					return c1Name.compareTo(c2Name);
				})
				.collect(Collectors.toList());

			for (ChartQuery chartQuery : chartQueries) {
				Query query = chartQuery.getQuery();
				Optional<String> sort = Optional.empty();
				Optional<String> sortDirection = Optional.empty();
				Optional<String> join = Optional.empty();
				Optional<String> select = Optional.empty();
				Optional<String> where = Optional.empty();
				Optional<String> group = Optional.empty();
				String[] keyValuePairs = query.getQueryString().split("&");
				for (String keyValuePairStr : keyValuePairs) {
					String[] keyValuePair = keyValuePairStr.split("=");
					String key = keyValuePair[0];
					String value = keyValuePair[1];
					switch (key) {
						case "sort":
							sort = Optional.of(value);
							break;
						case "sortDirection":
							sortDirection = Optional.of(value);
							break;
						case "join":
							join = Optional.of(value);
							break;
						case "select":
							select = Optional.of(value);
							break;
						case "where":
							where = Optional.of(URLDecoder.decode(value, "UTF-8"));
							break;
						case "group":
							group = Optional.of(value);
							break;
					}
				}

				String groupBy = GroupParameter.parse(group.orElse(null));

				Template template = new TemplateFactoryWrapper()
					.build(query.getTemplate(), new HashMap<>(), null);
				List<String> attributeNames = template.getAttributeNames();
				List<String> friendlyNames = template.getFriendlyNames();
				TemplateQuery.Table table = new TemplateQuery(
					template.getClass().getSimpleName(),
					template.getAttributeToFriendlyNameMap(),
					attributeNames,
					friendlyNames,
					getEntityNameToRepositoryMap()
				)
					.execute(
						SortParameter.parse(sort.orElse("id"), sortDirection.orElse("asc")),
						JoinParameter.parse(join.orElse(null)),
						SelectParameter.parse(select.orElse(null)),
						WhereParameter.parse(where.orElse(null)),
						groupBy
					);

				tables.add(table);
				List<Integer> rowData = new ArrayList<>();
				if (groupBy != null) {
					sourceLabels.add(query.getName());
					for (List<List<Object>> row : table.data) {
						rowData.add(row.size());
						labels.add((String) AttributeResolver.get(groupBy, row.get(0).get(0)));
					}
					data.add(rowData.toArray(new Integer[rowData.size()]));
				} else {
					labels.add(query.getName());
					if (data.size() == 0) {
						data.add(new Integer[]{});
					}
					Integer[] sdata = data.get(0);
					data.set(0, concat(sdata, new Integer[]{table.data.get(0).size()}));
				}
			}
			
			if (sourceLabels.size() == 0) {
				sourceLabels.add(chart.getName());
			}

			model.addAttribute("name", chart.getName());
			model.addAttribute("type", chart.getType());
			model.addAttribute("labels", labels.toArray());
			model.addAttribute("data", data.toArray());
			model.addAttribute("sourceLabels", sourceLabels.toArray());
		} catch (UnsupportedEncodingException err) {
			throw new RuntimeException(err);
		}
	} 

    @GetMapping("/charts/create")
    public String createView(Model model) {

		// Convert queries to JSON
		Iterable<Query> queries = queryRepository.findAll();
    	JSONArray queriesJSON = new JSONArray();
    	for (Query query : queries) {
			JSONObject queryJSON = new JSONObject();
			queryJSON.put("id", query.getId());
			queryJSON.put("name", query.getName());
			queriesJSON.put(queryJSON);
    	}
		model.addAttribute("queriesJSON", queriesJSON.toString());

		model.addAttribute("chart", new Chart());

        return "charts/create";
    }

    @PostMapping("/charts")
    public String create(@ModelAttribute Chart chart, @RequestParam String queries, Model model) {
    	chartRepository.save(chart);
    	populateChartQueries(model, chart, queries);
    	return "redirect:/charts";
    }

    @GetMapping("/charts/{id}/update")
   	public String updateView(Model model, @PathVariable String id) {

		// Convert queries to JSON
    	Iterable<Query> queries = queryRepository.findAll();
    	JSONArray queriesJSON = new JSONArray();
    	for (Query query : queries) {
			JSONObject queryJSON = new JSONObject();
			queryJSON.put("id", query.getId());
			queryJSON.put("name", query.getName());
			queriesJSON.put(queryJSON);
    	}
		model.addAttribute("queriesJSON", queriesJSON.toString());
		
		try {
            Long chartId = Long.parseLong(id);
            Chart chart = chartRepository.findById(chartId).get();
			model.addAttribute("chart", chart);
			
			List<ChartQuery> chartQueries = chart.getChartQueries().stream()
				.sorted((c1, c2) -> {
					String c1Name = c1.getQuery().getName();
					String c2Name = c2.getQuery().getName();
					return c1Name.compareTo(c2Name);
				})
				.collect(Collectors.toList());

			JSONArray chartQueriesJSON = new JSONArray();
			for (ChartQuery chartQuery : chartQueries) {
				Query query = chartQuery.getQuery();
				JSONObject queryJSON = new JSONObject();
				queryJSON.put("id", query.getId());
				queryJSON.put("name", query.getName());
				System.out.println(query.getName());
				chartQueriesJSON.put(queryJSON);
			}
			
			model.addAttribute("chartQueriesJSON", chartQueriesJSON.toString());
            return "charts/update";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

    @PostMapping("/charts/{id}/embed")
    public String updateById(Model model, @ModelAttribute Chart chart, @PathVariable String id, @RequestParam String queries) {
        chartRepository.save(chart);
        model.addAttribute("chart", chart);
        updateChartQueries(model, chart, queries);
        return "redirect:/charts";
    }

    private void updateChartQueries(Model model, Chart chart, String queries) {
    	Set<ChartQuery> newChartQueries = new HashSet<ChartQuery>();
    	/*
    	Set<ChartQuery> chartQueries = chart.getChartQueries();
    	chartQueries.clear();
    	chart.setChartQueries(chartQueries);
    	*/
    	
    	deleteChartQueriesForChart(chart.getId());
    	
	    for (String id : queries.split(",")) {
	    	ChartQuery chartQuery = new ChartQuery();
	    	
	    	Long queryId = Long.parseLong(id);
	        Optional<Query> optionalQuery = queryRepository.findById(queryId);
	        Query query = optionalQuery.get();
	    	
	    	chartQuery.setChart(chart);
	    	chartQuery.setQuery(query);
	
	    	newChartQueries.add(chartQuery);
	
	    	Set<ChartQuery> chartQueryQuery = query.getChartQueries();
	    	chartQueryQuery.add(chartQuery);
	    	query.setChartQueries(chartQueryQuery);
	
	    	chartQueryRepository.save(chartQuery);
	    }
    	
    	chart.setChartQueries(newChartQueries);
    }

    private void populateChartQueries(Model model, Chart chart, String queries) {
    	Set<ChartQuery> chartQueriesChart = new HashSet<ChartQuery>();

    	for (String id : queries.split(",")) {
    		ChartQuery chartQuery = new ChartQuery();
    		
    		Long queryId = Long.parseLong(id);
            Optional<Query> optionalQuery = queryRepository.findById(queryId);
            Query query = optionalQuery.get();
    		
    		chartQuery.setChart(chart);
    		chartQuery.setQuery(query);

    		chartQueriesChart.add(chartQuery);

    		Set<ChartQuery> chartQueryQuery = query.getChartQueries();
    		
    		chartQueryQuery.add(chartQuery);
    		query.setChartQueries(chartQueryQuery);

    		// model.addAttribute("chartQuery", chartQuery);
    		chartQueryRepository.save(chartQuery);
    	}
    	chart.setChartQueries(chartQueriesChart);
    }

    private void deleteChartQueriesForChart(Long chartId) {
    	List<ChartQuery> chartQueries = chartQueryRepository.findAll();
    	for (ChartQuery chartQuery : chartQueries) {
    		if (chartQuery.getChart().getId() == chartId) {
    			chartQuery.getChart().getChartQueries().remove(chartQuery);
    			chartQuery.getQuery().getChartQueries().remove(chartQuery);
    			chartQueryRepository.deleteById(chartQuery.getId());
    		}
    	}
    }

    /*
     * To manage test populations.
     */
    @DeleteMapping("/charts/{id}")
    public String deleteById(@PathVariable String id) {
        try {
			Long chartId = Long.parseLong(id);
			deleteChartQueriesForChart(chartId);
            chartRepository.deleteById(chartId);
            return "redirect:/charts";
        } catch (IllegalArgumentException | EmptyResultDataAccessException err) {
            throw new ChartNotFoundException();
        }
    }

	public Map<String, JpaRepository> getEntityNameToRepositoryMap() {
		Map<String, JpaRepository> map = new HashMap<>();
		map.put("ClientProfileTemplate", clientProfileTemplateRepository);
		map.put("NARsTemplate", narsTemplateRepository);
		map.put("CommunityConnectionsTemplate", communityConnectionsTemplateRepository);
		map.put("EmploymentTemplate", employmentTemplateRepository);
		map.put("InformationAndOrientationTemplate", informationAndOrientationTemplateRepository);
		map.put("LTClientEnrolTemplate", ltClientEnrolTemplateRepository);
		map.put("LTCourseSetupTemplate", ltCourseSetupTemplateRepository);
		map.put("LTClientExitTemplate", ltClientExitTemplateRepository);
		return map;
	}

	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	  }
}
