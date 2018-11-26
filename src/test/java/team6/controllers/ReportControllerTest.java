package team6.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import team6.models.Report;
import team6.repositories.ReportRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class ReportControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ReportController reportController;

	@Autowired
	private ReportRepository reportRepository;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListViewReports();

		assertEquals(expected, response.getBody());
	}

	

	@Test
	public void testCreateView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateView();

		assertEquals(expected, response.getBody());
	}

	private String createURL(String uri) {
		return "http://localhost:8080" + uri;
	}
}
