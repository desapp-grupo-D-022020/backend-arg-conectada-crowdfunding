package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public @ResponseBody String welcome(){
        //this is a change to trigger a codacy scan
        return "Hello, World!";
    }
}
