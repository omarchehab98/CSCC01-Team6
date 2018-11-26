package team6.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import team6.models.Chart;
import team6.repositories.ChartRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class ChartControllerTest {
	@Autowired
	private ChartRepository chartRepository;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/charts"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListViewCharts();

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

		String expected = ViewGenerators.getReadSingleViewCharts(id);

		assertEquals(expected, response.getBody());

		chartRepository.deleteById(chart.getId());
	}

	private String createURL(String uri) {
		return "http://localhost:8080" + uri;
	}
}
