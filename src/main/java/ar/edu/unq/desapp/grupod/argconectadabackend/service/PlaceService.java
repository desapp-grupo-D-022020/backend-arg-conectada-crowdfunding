package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IPlaceRepo;

@Service
public class PlaceService extends ServiceAbstract<Place, Integer> {
	
	@Autowired
	private static IPlaceRepo repo;	
	
	public PlaceService() { super(repo); }
}