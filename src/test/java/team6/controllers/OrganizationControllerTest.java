package team6.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
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

import team6.models.Organization;
import team6.repositories.OrganizationRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrganizationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OrganizationController organizationController;

	@Autowired
	private OrganizationRepository organizationRepository;

	Organization organization = new Organization();

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListView();

		assertEquals(expected, response.getBody());
	}

	/*
	@Test
	public void testReadByIdView() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String id = "5";

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations/" + id),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadSingleView(id);

		assertEquals(expected, response.getBody());
	}
	*/

	@Test
	public void testCreateView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations/create"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getCreateView();

		assertEquals(expected, response.getBody());
	}

	/*
	@Test
	public void testCreate() {
		HttpEntity<Organization> entity = new HttpEntity<Organization>(organization, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/organizations"));
	}
	*/

	@Test
	public void testUpdatedOrganization() throws Exception {
		HttpEntity<Organization> entity = new HttpEntity<Organization>(organization, headers);
		String id = "25";

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations/" + id),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/organizations/" + id));
	}

	/*
	@Test
	public void testUpdateByIdView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String id = "5";

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations/" + id + 
						"/update"), HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getUpdateView(id);

		assertEquals(expected, response.getBody());
	}
	*/

	/*
	@Test
	public void testDeleteById() throws Exception {
		HttpEntity<Organization> entity = new HttpEntity<Organization>(organization, headers);
		String id = "";

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/organizations/" + id),
				HttpMethod.DELETE, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertFalse(actual.contains("/organizations/" + id));
	}
	*/

	private String createURL(String uri) {
		return "http://localhost:8080" + uri;
	}

}
