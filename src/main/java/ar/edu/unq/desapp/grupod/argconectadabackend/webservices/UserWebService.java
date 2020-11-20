package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		User user = userService.getById(id);
		return new UserDTO(user.getId(), user.getName(), user.getUserName(),
						   user.getEmail(), user.getPoints(), user.getImg());
	}
}