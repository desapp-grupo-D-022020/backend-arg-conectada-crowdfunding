package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IUserRepo;

@Service
public class UserService extends AbstractService<User, Integer> {
	
	@Autowired
	IUserRepo repo;
	
	public UserService(IUserRepo repo) {
		super(repo);
	}
	
    public Optional<User> getByUserName(String userName){
        return repo.findByUserName(userName);
    }
    
    public boolean existByName(String name){
        return repo.existsByName(name);
    }

    public  boolean existByEmail(String email){
        return repo.existsByEmail(email);
    }
}