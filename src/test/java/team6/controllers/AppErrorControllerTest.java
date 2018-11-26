package team6.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AppErrorControllerTest {
	@Autowired
	private AppErrorController appErrorController;
	@LocalServerPort
    private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testHandleErrorNotFound() {
		
	}

	@Test
	public void testHandleErrorInternalServerError() {
		
	}

	@Test
	public void testGetErrorPath() {
		assertEquals("/error", appErrorController.getErrorPath());
	}

	private String createURL(String uri) {
		return "http://localhost:" + port + uri;
	}
}
