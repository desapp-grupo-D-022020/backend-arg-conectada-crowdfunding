package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.UserChangePictureDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.UserDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserWebService extends AbstractWebService<User> {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/getUserDTO/{id}")
	public UserDTO getUserDTOById(@PathVariable("id") int id) {
		return this.userService.getUserDTOById(id);
	}
	
	@PutMapping(value="/changeProfilePicture")
	public void donate(@ModelAttribute UserChangePictureDTO userDataPicture) throws IOException {
		this.userService.changeProfilePicture(userDataPicture);
	}
}