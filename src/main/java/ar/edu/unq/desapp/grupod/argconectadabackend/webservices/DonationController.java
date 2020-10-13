package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;

@RestController
@RequestMapping("/projects")
public class DonationController extends AbstractController<Donation> {}