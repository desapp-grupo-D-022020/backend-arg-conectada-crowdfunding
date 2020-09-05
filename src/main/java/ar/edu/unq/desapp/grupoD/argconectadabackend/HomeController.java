package ar.edu.unq.desapp.grupoD.argconectadabackend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String welcome(){
        return "Hello, World!";
    }
}
