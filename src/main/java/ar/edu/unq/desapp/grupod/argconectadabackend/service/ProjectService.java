package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.DonationDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.InfoProjectDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.ProjectDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IProjectRepo;

@Service
public class ProjectService extends AbstractService<Project, Integer> {
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private PointsManagerService pointsManager;
	
	private IProjectRepo repository;
	
	private UserService userService;
	
	private PlaceService placeService;
	
	@Autowired
	public ProjectService(IProjectRepo repository, UserService userService,
			PlaceService placeService){
		super(repository);
		this.repository = repository;
		this.userService =  userService;
		this.placeService = placeService;
	}

	@Transactional
	public void createProject(ProjectDTO projectDto) {
		Place place = placeService.getById(Integer.parseInt( projectDto.getPlaceId()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime startDate = LocalDateTime.parse(projectDto.getStartDate() + " 00:00", formatter);
		LocalDateTime endDate = LocalDateTime.parse(projectDto.getEndDate() + " 00:00", formatter);
	
		this.save(new Project(place, projectDto.getName(), startDate, endDate, 
				Double.parseDouble(projectDto.getFactor()), Double.parseDouble(projectDto.getPercentageForClose())));
	}
	
	@Transactional
	public void closeProject(int id) {
		Project projectToClose = this.getById(id);
		projectToClose.closeProject();
		this.update(projectToClose);
		
		List<User> donors = projectToClose.getDonors();
		for(User donor : donors) {
			System.out.println(donor.getEmail());
			this.emailSender.closeProjectEmail(donor.getEmail(), donor.getUserName(), 
					projectToClose.getName(), projectToClose.getPlace().getName());
		}
		
		//this.delete(id);
	}
	
	@Transactional
	public Page<InfoProjectDTO> getOpenProjects(Pageable pageable) {
		int currentMonth = LocalDateTime.now().getMonthValue();
		int currentYear= LocalDateTime.now().getYear();
		
		Page<Project> page = this.repository.getOpenProjects(pageable, currentMonth, currentYear);
		
		List<InfoProjectDTO> oponeProject = page.get().map(
				project -> new InfoProjectDTO(project.getId(), project.getName(), project.getPlace().getName(), 
												project.getPlace().getProvince(), project.getPlace().getStatus(), 
												this.totalRaised(project.getId()), project.missingPercentage())).collect(Collectors.toList());
		
		return new PageImpl<InfoProjectDTO>(oponeProject, pageable, page.getTotalElements());
	}
	
	@Transactional
	public Page<InfoProjectDTO> getNearlyClosedProjects(Pageable pageable) {
		int currentMonth = LocalDateTime.now().getMonthValue();
		int currentYear= LocalDateTime.now().getYear();
		int currentDay= LocalDateTime.now().getDayOfMonth();
			
		Page<Project> page = this.repository.getNearlyClosedProjects(pageable, currentMonth, currentYear, currentDay);
		
		List<InfoProjectDTO> oponeProject = page.get().map(
				project -> new InfoProjectDTO(project.getId(), project.getName(), project.getPlace().getName(), 
												project.getPlace().getProvince(), project.getPlace().getStatus(), 
												this.totalRaised(project.getId()), project.missingPercentage())).collect(Collectors.toList());
		
		return new PageImpl<InfoProjectDTO>(oponeProject, pageable, page.getTotalElements());
	}
	
	@Transactional
	public double getCost(int id) {
		return this.getById(id).getCost();
	}
	
	@Transactional
	public double totalRaised(int id) {
		return this.getById(id).totalRaised();
	}
	
	@Transactional
	public double missingPercentage(int id) {
		return this.getById(id).missingPercentage();
	}
	
	@Transactional
	public void donate(DonationDTO donationDto) {
		Project projectToReceiveDonation = this.getById(Integer.parseInt(donationDto.getProjectId()));
		User donor = userService.getById(Integer.parseInt(donationDto.getUserId()));
		Double amount = Double.parseDouble(donationDto.getAmount());
		projectToReceiveDonation.receiveDonation(donor, this.pointsManager.assignPoints(donor, projectToReceiveDonation, amount)
				, amount, donationDto.getComment());
		this.userService.update(donor);
		this.update(projectToReceiveDonation);
		System.out.println(this.userService.getById(donor.getId()).getPoints());
	}
	
	@Transactional
	public List<Project> getTopTenProjectsWithMoreTimeWithoutDonations() {
		List<Project> topTen = new ArrayList<Project>();
		List<Project> projects = this.getAll();
		while(topTen.size() < 10 && !projects.isEmpty()) {
			Project projectToAdd = this.getProjectWithMoreTimeWithoutDonations(projects);
			topTen.add(projectToAdd);
			projects.remove(projectToAdd);
		}
		return topTen;
	}
	
	@Transactional
	public List<Donation> getTopTenDonations() {	
		return this.getAll().stream().map(project -> project.getDonations()).flatMap(Collection::stream)
				.sorted(this::compare)
				.limit(10)
				.collect(Collectors.toList());
	}
	
	private int compare(Donation aDonation, Donation otherDonation) {
		Double anAmount = aDonation.getAmount();
		Double otherAmount = otherDonation.getAmount();
		if (anAmount == otherAmount) return 0;
		else return anAmount > otherAmount ? -1 : 1;
	}

	private Project getProjectWithMoreTimeWithoutDonations(List<Project> projects) {
		
		Collections.sort(projects, (p1, p2) -> {
			return p1.getLastDonationDate().compareTo(p2.getLastDonationDate());
		});
		
		Project projectWithMoreTimeWithoutDonations = projects.remove(0);
		for(Project project : projects) 
			if(project.getLastDonationDate().isBefore(projectWithMoreTimeWithoutDonations.getLastDonationDate()))
				projectWithMoreTimeWithoutDonations = project;
		
		return projectWithMoreTimeWithoutDonations;
	}
}