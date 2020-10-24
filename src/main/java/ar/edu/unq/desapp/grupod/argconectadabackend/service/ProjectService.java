package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.DonationDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.ProjectDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IProjectRepo;

@Service
public class ProjectService extends AbstractService<Project, Integer> {
	
	@Autowired
	private EmailSender emailSender;
	
	@Autowired
	private PointsManagerService pointsManager;
	
	@Autowired
	public ProjectService(IProjectRepo repo) { super(repo); }
	
	@Transactional
	public void createProject(ProjectDto projectDto) {
		this.save(new Project(projectDto.getPlace(), projectDto.getNameOfProject(), projectDto.getStartDate(), projectDto.getEndDate()));
	}
	
	@Transactional
	public void closeProject(int id) {
		Project projectToClose = this.getById(id);
		projectToClose.closeProject();
		this.update(projectToClose);
		
		List<User> donors = projectToClose.getDonors();
		for(User donor : donors) {
			this.emailSender.closeProjectEmail(donor.getEmail(), donor.getNickName());
		}
	}
	
	@Transactional
	public List<Project> getOpenProjects() {
		int currentMonth = LocalDateTime.now().getMonthValue();
		int currentYear= LocalDateTime.now().getYear();
		
		Predicate<Project> gtMonthCondition = project -> project.getEndDate().getMonthValue() > currentMonth;
		Predicate<Project> eqMonthDiffYearCondition = project -> project.getEndDate().getMonthValue() == currentMonth && project.getEndDate().getYear() > currentYear;
		return this.getAll().stream().filter(gtMonthCondition.or(eqMonthDiffYearCondition)).collect(Collectors.toList());
	}
	
	@Transactional
	public List<Project> getNearlyClosedProjects() {
		int currentMonth = LocalDateTime.now().getMonthValue();
		int currentYear= LocalDateTime.now().getYear();
		
		Predicate<Project> eqMonthCondition = project -> project.getEndDate().getMonthValue() == currentMonth;
		Predicate<Project> eqYearCondition = project -> project.getEndDate().getYear() == currentYear;
		return this.getAll().stream().filter(eqMonthCondition.and(eqYearCondition)).collect(Collectors.toList());
	}
	
	@Transactional
	public double getCost(int id) {
		return this.getById(id).getCost();
	}
	
	@Transactional
	public void donate(DonationDto donationDto) {
		Project projectToReceiveDonation = this.getById(donationDto.getProjectId());
		User donor = donationDto.getUser();
		Double amount = donationDto.getAmount();
		projectToReceiveDonation.receiveDonation(donor, amount, donationDto.getCommentary());
		this.pointsManager.assignPoints(donor, projectToReceiveDonation, amount);
		this.update(projectToReceiveDonation);
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