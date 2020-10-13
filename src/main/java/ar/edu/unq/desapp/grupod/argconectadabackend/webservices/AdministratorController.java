package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Administrator;

@RestController
@RequestMapping("/administrators")
public class AdministratorController extends AbstractController<Administrator> {}