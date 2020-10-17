package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IProjectRepo;

@Service
public class ProjectService extends ServiceAbstract<Project, Integer> {
	
	@Autowired
	private static IProjectRepo repo;	
	
	public ProjectService() { super(repo); }
}