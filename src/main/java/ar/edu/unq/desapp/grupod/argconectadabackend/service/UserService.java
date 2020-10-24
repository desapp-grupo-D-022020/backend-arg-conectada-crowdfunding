package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IUserRepo;

@Service
public class UserService extends AbstractService<User, Integer> {
	
	@Autowired
	public UserService(IUserRepo repo, PointsManagerService pointsManager) { 
		super(repo); 
	}
}