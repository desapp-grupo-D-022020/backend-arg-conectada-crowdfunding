package ar.edu.unq.desapp.grupod.argconectadabackend.application;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ArgconectadaBackendApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getHomepageWithRandomPortShouldReturnMessage() throws Exception {
    	String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertTrue(response.contentEquals("Hello, World!"), "wrong response");
	}

}
