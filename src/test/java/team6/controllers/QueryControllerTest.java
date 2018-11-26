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

import team6.models.Query;
import team6.repositories.QueryRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class QueryControllerTest {
	@Autowired
	private QueryRepository queryRepository;
	@LocalServerPort
    private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListView(port, "/queries/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testCreateView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateView(port, "/queries/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadByIdView() throws Exception {
		Query query = new Query();
		queryRepository.save(query);
		String id = String.valueOf(query.getId());
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/" + id),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadSingleView(port, "/queries/", id);

		assertEquals(expected, response.getBody());

		queryRepository.deleteById(query.getId());
	}

	/*
	@Test
	public void testCreate() {
		Query query = new Query();
		HttpEntity<Query> entity = new HttpEntity<Query>(query, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/queries"));
	}
	*/

	public void testUpdateByIdView() {
		Query query = new Query();
		queryRepository.save(query);
		String id = String.valueOf(query.getId());
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/" + id + 
						"/update"), HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getUpdateView(port, "/queries/", id);

		assertEquals(expected, response.getBody());

		queryRepository.deleteById(query.getId());
	}

	@Test
	public void testUpdateById() throws Exception {
		Query query = new Query();
		queryRepository.save(query);
		String id = String.valueOf(query.getId());
		HttpEntity<Query> entity = new HttpEntity<Query>(query, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/" + id),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/queries/" + id));
		
		queryRepository.deleteById(query.getId());
	}

	public void testDeleteById() throws Exception {
		Query query = new Query();
		queryRepository.save(query);
		HttpEntity<Query> entity = new HttpEntity<Query>(query, headers);
		String id = String.valueOf(query.getId());

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/queries/" + id),
				HttpMethod.DELETE, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertFalse(actual.contains("/queries/" + id));
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
