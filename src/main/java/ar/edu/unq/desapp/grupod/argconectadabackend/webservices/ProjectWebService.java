package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.DonationDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.InfoProjectDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.ProjectDTO;
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
	
	@GetMapping(value="/getOpenProjects")
	public Page<InfoProjectDTO> getOpenProjects(
			@PageableDefault(size = 5) Pageable pageable,
			@RequestParam(defaultValue = "0") int page
			) {
		return this.projectService.getOpenProjects(pageable);
	}
	
	@GetMapping(value="/getNearlyClosedProjects")
	public Page<InfoProjectDTO> getNearlyClosedProjects(
			@PageableDefault(size = 5) Pageable pageable,
			@RequestParam(defaultValue = "0") int page
			) {
		return this.projectService.getNearlyClosedProjects(pageable);
	}
	
	@PutMapping(value="/closeProject/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void closeProject(@PathVariable("id") int id) {
		this.projectService.closeProject(id);
	}
	
	@PostMapping(value="/createProject")
	@PreAuthorize("hasRole('ADMIN')")
	public void createProject(@ModelAttribute ProjectDTO project) {
		this.projectService.createProject(project);
	}
	
	@PutMapping(value="/donate")
	public void donate(@ModelAttribute DonationDTO donationDto) {
		this.projectService.donate(donationDto);
	}
}