package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectWebService extends AbstractWebService<Project> {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping(value="/donate")
	public void insert(@RequestBody int id, User user, double amount, String commentary) {
		projectService.donate(id, user,  amount, commentary);
	}
	
}