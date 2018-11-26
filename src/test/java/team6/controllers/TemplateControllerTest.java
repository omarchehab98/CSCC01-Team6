package team6.controllers;

import static org.junit.Assert.assertEquals;
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

import team6.models.NARsTemplate;
import team6.repositories.ClientProfileTemplateRepository;
import team6.repositories.CommunityConnectionsTemplateRepository;
import team6.repositories.NARsTemplateRepository;
import team6.throwables.IllegalTemplateException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TemplateControllerTest {
	@Autowired
    private NARsTemplateRepository narsTemplateRepository;
    @Autowired
    private ClientProfileTemplateRepository clientProfileTemplateRepository;
    @Autowired
    private CommunityConnectionsTemplateRepository communityConnectionsTemplateRepository;

    @Autowired
	private TemplateController templateController;

    @LocalServerPort
    private int port;

    NARsTemplate narsTemplate = new NARsTemplate();

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testReadAllView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadListView(port, "/templates/");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllNARsView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/NARs"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/NARs");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllClientProfileView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/clientProfile"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/clientProfile");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllCommunityConnectionsView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/communityConnections"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/communityConnections");

		assertEquals(expected, response.getBody());
	}

	/*
	@Test
	public void testCreateTemplateByFile() throws Exception {
		HttpEntity<NARsTemplate> entity = new HttpEntity<NARsTemplate>(narsTemplate, headers);
		
		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates"),
				HttpMethod.POST, entity, String.class);

		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		assertTrue(actual.contains("/templates"));
	}
	*/

	@Test
	public void testGetRepo() throws IllegalTemplateException {
		assertEquals(narsTemplateRepository,
				templateController.getRepo("NARs"));
		assertEquals(clientProfileTemplateRepository, 
				templateController.getRepo("clientProfile"));
		assertEquals(communityConnectionsTemplateRepository, 
				templateController.getRepo("communityConnections"));
	}

	@Test(expected = IllegalTemplateException.class)
	public void testGetRepoException() throws IllegalTemplateException {
		templateController.getRepo("");
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
