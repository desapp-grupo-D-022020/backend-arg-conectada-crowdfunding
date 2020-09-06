package ar.edu.unq.desapp.grupod.argconectadabackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public @ResponseBody String welcome(){
        return "Hello, World!";
    }
}