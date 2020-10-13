package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;

@RestController
@RequestMapping("/places")
public class PlaceController extends AbstractController<Place> {}