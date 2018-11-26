package team6.controllers;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import team6.models.Chart;
import team6.repositories.ChartRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ChartControllerTest {
	@Autowired
	private ChartRepository chartRepository;
	@LocalServerPort
    private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/charts"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListView(port, "/charts/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadByIdView() throws Exception {
		Chart chart = new Chart();
		chartRepository.save(chart);
		String id = String.valueOf(chart.getId());
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/charts/" + id + "/embed"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadSingleViewCharts(port, id);

		assertEquals(expected, response.getBody());

		chartRepository.deleteById(chart.getId());
	}

	@Test
	public void testCreateview() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/charts/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateView(port, "/charts/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testUpdateView() {
		Chart chart = new Chart();
		chartRepository.save(chart);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String id = String.valueOf(chart.getId());

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/charts/" + id + 
						"/update"), HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getUpdateViewCharts(port, id);

		assertEquals(expected, response.getBody());

		chartRepository.deleteById(chart.getId());
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
