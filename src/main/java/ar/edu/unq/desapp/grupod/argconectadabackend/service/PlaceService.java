package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.PlaceDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IPlaceRepo;

@Service
public class PlaceService extends AbstractService<Place, Integer> {
	
	@Autowired
	public PlaceService(IPlaceRepo repo) { super(repo); }
	
	@Transactional
	public List<PlaceDTO> placesWithoutProject() {
		return this.getAll().stream().filter(place -> place.getProject() == null)
				.map(place -> new PlaceDTO(place.getId(), place.getName())).collect(Collectors.toList());
	}
}