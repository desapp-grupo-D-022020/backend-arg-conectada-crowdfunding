package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Administrator;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IAdministratorRepo;

@Service
public class AdministratorService extends ServiceAbstract<Administrator, Integer> {
	
	@Autowired
	private static IAdministratorRepo repo;	
	
	public AdministratorService() { super(repo); }
}