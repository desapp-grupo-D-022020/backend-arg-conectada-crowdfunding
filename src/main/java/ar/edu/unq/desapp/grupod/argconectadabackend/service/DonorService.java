package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donor;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IDonorRepo;

@Service
public class DonorService extends ServiceAbstract<Donor, Integer> {
	
	@Autowired
	private static IDonorRepo repo;	
	
	public DonorService() { super(repo); }
}