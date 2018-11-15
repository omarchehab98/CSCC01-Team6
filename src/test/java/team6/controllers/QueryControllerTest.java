package team6.controllers;

import static org.junit.Assert.assertEquals;
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

import team6.models.Query;
import team6.repositories.QueryRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class QueryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private QueryRepository queryRepository;

	@Autowired
	private QueryController queryController;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	Query query = new Query();

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

	/*
	@Test
	public void testSaveQuery() {
		HttpEntity<Query> entity = new HttpEntity<Query>(query, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/queries"));
	}
	*/

	private String createURL(String uri) {
		return "http://localhost:8080" + uri;
	}
}
