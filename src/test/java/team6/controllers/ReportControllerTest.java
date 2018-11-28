package team6.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import team6.models.Report;
import team6.repositories.ReportRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ReportControllerTest {
	@Autowired
	private ReportRepository reportRepository;
	@LocalServerPort
    private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllReports() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListView(port, "/reports/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadByIdView() throws Exception {
		Report report = new Report();
		reportRepository.save(report);
		String id = String.valueOf(report.getId());
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/" + id + "/embed"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadSingleViewReports(port, id);

		assertEquals(expected, response.getBody());

		reportRepository.deleteById(report.getId());
	}

	@Test
	public void testCreateSingleReport() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateView(port, "/reports/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testCreate() {
		Report report = new Report();
		HttpEntity<Report> entity = new HttpEntity<Report>(report, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/reports"));
	}

	public void testUpdateReport() {
		Report report = new Report();
		reportRepository.save(report);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String id = String.valueOf(report.getId());

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/" + id + 
						"/update"), HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getUpdateView(port, "/reports/", id);

		assertEquals(expected, response.getBody());

		reportRepository.deleteById(report.getId());
	}

	@Test
	public void testSaveUpdateReport() throws Exception {
		Report report = new Report();
		reportRepository.save(report);
		HttpEntity<Report> entity = new HttpEntity<Report>(report, headers);
		String id = String.valueOf(report.getId());

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/" + id),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/reports"));
		
		reportRepository.deleteById(report.getId());
	}

	public void testDeleteById() throws Exception {
		Report report = new Report();
		reportRepository.save(report);
		HttpEntity<Report> entity = new HttpEntity<Report>(report, headers);
		String id = String.valueOf(report.getId());

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/reports/" + id),
				HttpMethod.DELETE, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertFalse(actual.contains("/reports/" + id));
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
