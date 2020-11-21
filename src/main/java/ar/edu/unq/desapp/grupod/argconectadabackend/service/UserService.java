package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.UserChangePictureDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.UserDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IUserRepo;

@Service
public class UserService extends AbstractService<User, Integer> {
	
	@Autowired
	IUserRepo repo;
	
	public UserService(IUserRepo repo) {
		super(repo);
	}
	
	@Transactional
    public Optional<User> getByUserName(String userName){
        return repo.findByUserName(userName);
    }
    
	@Transactional
    public boolean existByName(String name){
        return repo.existsByName(name);
    }

	@Transactional
    public  boolean existByEmail(String email){
        return repo.existsByEmail(email);
    }
    
	@Transactional
    public String[] getEmailFromAllUser(){
    	return  this.getAll().stream().map(user -> user.getEmail()).toArray(String[]::new);
    }
    
	@Transactional
	public UserDTO getUserDTOById(int id) {
		User user = this.getById(id);
		return new UserDTO(user.getId(), user.getName(), user.getUserName(),
						   user.getEmail(), user.getPoints(), user.getImg());
	}
	
	@Transactional
	public void changeProfilePicture(UserChangePictureDTO userDataPicture) throws IOException {
		User user = this.getById(Integer.parseInt(userDataPicture.getUserId()));
		user.setImg(userDataPicture.getImg().getBytes());
		this.update(user);
	}
	
}