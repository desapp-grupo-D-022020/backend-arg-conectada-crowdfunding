package ar.edu.unq.desapp.grupod.argconectadabackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class HomeTest {
    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception {
        Assert.notNull(controller,"The controller must not be null");
    }
}
