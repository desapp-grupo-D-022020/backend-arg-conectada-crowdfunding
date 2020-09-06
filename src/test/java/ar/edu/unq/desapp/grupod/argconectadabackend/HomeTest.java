package ar.edu.unq.desapp.grupod.argconectadabackend;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HomeTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private HomeController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        assertNotNull(controller, "The controller must not be null");
    }
    
    @Test
	void homeShouldReturnDefaultMessage() throws Exception {
    	String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertTrue(response.contentEquals("Hello, World!"), "wrong response");
	}
}
