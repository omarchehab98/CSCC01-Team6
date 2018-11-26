package team6.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ViewGenerators {

	static RestTemplate restTemplate = new RestTemplate();

	HttpHeaders headers = new HttpHeaders();

	public ViewGenerators() {}

	public static String getReadListView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/organizations", 
						String.class);
		String res = response.getBody();
		return 	res;
	}

	public static String getReadSingleView(String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/organizations/" 
						+ id, String.class);
		String res = response.getBody();
		return res;
	}

	public static String getCreateView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/organizations/" 
						+ "create", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getUpdateView(String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/organizations/" 
						+ id + "/update", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getHomeView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/", 
						String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadAllView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/templates", 
						String.class);
		String res = response.getBody();
		return 	res;
	}

	public static String getReadAllCommunityConnectionsView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/templates" 
						+ "/communityConnections", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadAllNARsView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/templates" 
						+ "/NARs", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadAllClientProfileView() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/templates" 
						+ "/clientProfile", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadAllViewQuesries() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/queries", 
						String.class);
		String res = response.getBody();
		return res;
	}

	public static String getCreateViewQueries() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/queries/" 
						+ "create", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadListViewReports() {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:8080/reports", 
						String.class);
		String res = response.getBody();
		return res;
	}
}
