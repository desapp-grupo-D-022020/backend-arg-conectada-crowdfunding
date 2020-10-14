package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeWebService {

	@GetMapping(path = "/")
    public @ResponseBody String welcome(){
        return "Hello, World!";
    }
}
