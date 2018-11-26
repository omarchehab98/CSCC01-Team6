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
import team6.repositories.EmploymentTemplateRepository;
import team6.repositories.InformationAndOrientationTemplateRepository;
import team6.repositories.LTClientEnrolTemplateRepository;
import team6.repositories.LTClientExitTemplateRepository;
import team6.repositories.LTCourseSetupTemplateRepository;
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
    private EmploymentTemplateRepository employmentTemplateRepository;
    @Autowired
    private InformationAndOrientationTemplateRepository informationAndOrientationTemplateRepository;
    @Autowired
    private LTClientEnrolTemplateRepository ltClientEnrolTemplateRepository;
    @Autowired
    private LTCourseSetupTemplateRepository ltCourseSetupTemplateRepository;
    @Autowired
    private LTClientExitTemplateRepository ltClientExitTemplateRepository;

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
				restTemplate.exchange(createURL("/templates/NARsTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/NARsTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllClientProfileView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/ClientProfileTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/ClientProfileTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllCommunityConnectionsView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/CommunityConnectionsTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/CommunityConnectionsTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllEmploymentView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/EmploymentTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/EmploymentTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllInformationAndOrientationView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/InformationAndOrientationTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/InformationAndOrientationTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllLTClientEnrolView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/LTClientEnrolTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/LTClientEnrolTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllLTCourseSetupView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/LTCourseSetupTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/LTCourseSetupTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testReadAllLTClientExitView() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = 
				restTemplate.exchange(createURL("/templates/LTClientExitTemplate"),
				HttpMethod.GET, entity, String.class);

		String expected = ViewGenerators.getReadAllTemplateView(port, "/LTClientExitTemplate");

		assertEquals(expected, response.getBody());
	}

	@Test
	public void testGetRepo() throws IllegalTemplateException {
		assertEquals(narsTemplateRepository,
				templateController.getEntityNameToRepositoryMap().get("NARsTemplate"));
		assertEquals(clientProfileTemplateRepository, 
				templateController.getEntityNameToRepositoryMap().get("ClientProfileTemplate"));
		assertEquals(communityConnectionsTemplateRepository, 
				templateController.getEntityNameToRepositoryMap().get("CommunityConnectionsTemplate"));
		assertEquals(employmentTemplateRepository,
				templateController.getEntityNameToRepositoryMap().get("EmploymentTemplate"));
		assertEquals(informationAndOrientationTemplateRepository, 
				templateController.getEntityNameToRepositoryMap().get("InformationAndOrientationTemplate"));
		assertEquals(ltClientEnrolTemplateRepository, 
				templateController.getEntityNameToRepositoryMap().get("LTClientEnrolTemplate"));
		assertEquals(ltCourseSetupTemplateRepository,
				templateController.getEntityNameToRepositoryMap().get("LTCourseSetupTemplate"));
		assertEquals(ltClientExitTemplateRepository, 
				templateController.getEntityNameToRepositoryMap().get("LTClientExitTemplate"));
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
