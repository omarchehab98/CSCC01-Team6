package team6.controllers;

import static org.junit.Assert.assertEquals;
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

import team6.models.Query;
import team6.repositories.QueryRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class QueryControllerTest {
	@Autowired
	private QueryRepository queryRepository;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllViewQuesries();

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testCreateView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateViewQueries();

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadByIdView() throws Exception {
		Query query = new Query();
		queryRepository.save(query);
		String id = String.valueOf(query.getId());
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/query/" + id),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadSingleViewQueries(id);

		assertEquals(expected, response.getBody());

		queryRepository.deleteById(query.getId());
	}

	

	private String createURL(String uri) {
		return "http://localhost:8080" + uri;
	}
}
