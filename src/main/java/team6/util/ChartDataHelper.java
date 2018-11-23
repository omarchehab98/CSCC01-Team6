package team6.util;

import java.util.ArrayList;
import java.util.HashMap;

import team6.models.Query;
import team6.util.ChartData;

public class ChartDataHelper {

	public static ChartData dataFromQuery(ArrayList<Query> queryList) {
		ArrayList<String> labelList = new ArrayList<>();
		ArrayList<String> sourceList = new ArrayList<>();
		ArrayList<ArrayList<Integer>> datasetList = new ArrayList<>();

		for (Query query : queryList) {
			sourceList.add(query.getName());

			HashMap<String, String> map = new HashMap<>();
			String queryString = query.getQueryString();
			String[] parameterList = queryString.split("&");
			for (String parameter : parameterList) {
				String[] nameValuePair = parameter.split("=");
				map.put(nameValuePair[0], nameValuePair[1]);
			}
		}
		ChartData data = new ChartData();
		return data;
	}
}