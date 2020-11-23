package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.PlaceDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.PlaceService;

@RestController
@RequestMapping("/places")
public class PlaceWebService extends AbstractWebService<Place> {
	@Autowired
	private PlaceService placeService;
	
	@GetMapping(value="/getPlacesWithoutProject")
	public List<PlaceDTO> placesWithoutProject() {
		return this.placeService.placesWithoutProject();
	}
	
}