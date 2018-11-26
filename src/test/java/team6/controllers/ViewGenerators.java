package team6.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ViewGenerators {

	static RestTemplate restTemplate = new RestTemplate();

	HttpHeaders headers = new HttpHeaders();

	public ViewGenerators() {}

	public static String getReadListView(int port, String controller) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + 
						controller, String.class);
		String res = response.getBody();
		return 	res;
	}

	public static String getReadSingleView(int port, String controller, String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + 
						controller  + id, String.class);
		String res = response.getBody();
		return res;
	}

	public static String getCreateView(int port, String controller) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + 
						controller + "/create", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getUpdateView(int port, String controller, String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port +
						controller + id + "/update", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getHomeView(int port) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + "/", 
						String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadAllTemplateView(int port, String template) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + "/templates" 
						+ template, String.class);
		String res = response.getBody();
		return res;
	}

	public static String getReadSingleViewCharts(int port, String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + "/charts/" 
						+ id + "/embed", String.class);
		String res = response.getBody();
		return res;
	}

	public static String getUpdateViewCharts(int port, String id) {
		ResponseEntity<String> response = 
				restTemplate.getForEntity("http://localhost:" + port + "/charts/" 
						+ id + "/update", String.class);
		String res = response.getBody();
		return res;
	}
}
