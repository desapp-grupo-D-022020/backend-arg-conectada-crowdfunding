package ar.edu.unq.desapp.grupod.argconectadabackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;

import ar.edu.unq.desapp.grupod.argconectadabackend.HomeController;

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
        Assert.notNull(controller,"The controller must not be null");
    }
    
    @Test
	void homeShouldReturnDefaultMessage() throws Exception {
    	String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		Assert.isTrue(response.contentEquals("Hello, World!"), "wrong response");
	}
}
