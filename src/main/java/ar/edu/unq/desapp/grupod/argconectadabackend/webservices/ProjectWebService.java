package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.DonationDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.ProjectDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectWebService extends AbstractWebService<Project> {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping(value="/getTopTenDonations")
	public List<Donation> getTopTenDonations() {	
		return projectService.getTopTenDonations();
	}
	
	@GetMapping(value="/getTopTenProjectsWithMoreTimeWithoutDonations")
	public List<Project> getTopTenProjectsWithMoreTimeWithoutDonations() {
		return this.projectService.getTopTenProjectsWithMoreTimeWithoutDonations();
	}
	
	@GetMapping(value="/getCost/{id}")
	public double getCost(@PathVariable("id") int id) {
		return this.projectService.getCost(id);
	}
	
	@GetMapping(value="/getNearlyClosedProjects")
	public List<Project> getNearlyClosedProjects() {
		return this.projectService.getNearlyClosedProjects();
	}
	
	@GetMapping(value="/getOpenProjects")
	public List<Project> getOpenProjects() {
		return this.getOpenProjects();
	}
	
	@PutMapping(value="/closeProject/{id}")
	public void closeProject(@PathVariable("id") int id) {
		this.projectService.closeProject(id);
	}
	
	@PostMapping(value="/createProject")
	public void createProject(@RequestBody ProjectDto projectDto) {
		this.projectService.createProject(projectDto);
	}
	
	@PutMapping(value="/donate")
	public void donate(@RequestBody DonationDto donationDto) {
		this.projectService.donate(donationDto);
	}
}