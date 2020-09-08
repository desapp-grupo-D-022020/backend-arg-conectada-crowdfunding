package ar.edu.unq.desapp.grupod.argconectadabackend.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unq.desapp.grupod.argconectadabackend.webservices.HomeController;

@SpringBootTest
class HomeTest {
	
	@Autowired
	private HomeController controller;

    @Test
    void contextLoads() throws Exception {
        assertNotNull(controller, "The controller must not be null");
    }
    
    @Test
    void homeShouldReturnMessage() {
    	String response = controller.welcome();
    	assertTrue(response.contentEquals("Hello, World!"), "Wrong response");
    }
}
