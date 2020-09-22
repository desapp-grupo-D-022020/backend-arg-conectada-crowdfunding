package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ProjectManagerTest {
	
	private ProjectManager projectManager;
	private List<Project> projects;
	private List<Project> anotherProjects;
	private Project project;
	private Project anotherProject;
	private Project testProject1;
	private Place place;
	private Place anotherPlace;
	private Donation donation;
	private Donation anotherDonation;
	private List<Donation> projectDonations;
	
	@BeforeEach
	void setUp() {
		place = mock(Place.class);
		anotherPlace = mock(Place.class);
		project = mock(Project.class);
		anotherProject = mock(Project.class);
		testProject1 = mock(Project.class);
		donation = mock(Donation.class);
		anotherDonation = mock(Donation.class);
		
		//calculate last day of month
		LocalDateTime now = LocalDateTime.now();
		Month currentMonth = now.getMonth();
		int currentYear = now.getYear();
		LocalDate firstOfThisMonth = LocalDate.of(currentYear, currentMonth, 1);
		LocalDate lastDateOfMonth = firstOfThisMonth.with(TemporalAdjusters.lastDayOfMonth());
		when(project.getEndDate()).thenReturn(lastDateOfMonth.atStartOfDay());
		
		int nextYear = currentYear + 1;
		LocalDate firstOfThisMonthOnNextYear = LocalDate.of(nextYear, currentMonth, 1);
		LocalDate lastDateOfMonthOnNextYear = firstOfThisMonthOnNextYear.with(TemporalAdjusters.lastDayOfMonth());
		when(anotherProject.getEndDate()).thenReturn(lastDateOfMonthOnNextYear.atStartOfDay());
		
		when(project.getPlace()).thenReturn(place);
		when(anotherProject.getPlace()).thenReturn(anotherPlace);
		
		when(donation.getAmount()).thenReturn(10.0);
		when(anotherDonation.getAmount()).thenReturn(500.0);
		
		projectDonations = new ArrayList<Donation>();
		projectDonations.add(donation);
		projectDonations.add(anotherDonation);
		
		anotherProjects = new ArrayList<Project>();
		anotherProjects.add(testProject1);
		
		projects = new ArrayList<Project>();
		projects.add(project);
		projects.add(anotherProject);
		
		projectManager = new ProjectManager(projects);
	}

	@Test
	void testGetProjects() {
		assertEquals(projects, projectManager.getProjects());
	}

	@Test
	void testSetProjects() {
		assertNotEquals(anotherProjects, projectManager.getProjects());
		projectManager.setProjects(anotherProjects);
		assertEquals(anotherProjects, projectManager.getProjects());
	}
	
	/*
	 * open projects: anotherProject
	 */
	@Test
	void testGetOpenProjects() {
		assertEquals(1, projectManager.getOpenProjects().size());
		assertEquals(anotherProject, projectManager.getOpenProjects().get(0));
	}

	/*
	 * nearly closed  projects: project
	 */
	@Test
	void testGetNearlyCloseProjects() {
		assertEquals(1, projectManager.getNearlyClosedProjects().size());
		assertEquals(project, projectManager.getNearlyClosedProjects().get(0));
	}
	
	@Test
	void testGetProjectByPlace() {
		assertEquals(project,projectManager.getProject(place));
	}

	@Test
	void testGetCost() {
		verify(project, times(0)).getCost();
		projectManager.getCost(place);
		verify(project, times(1)).getCost();
	}

	@Test
	void testCreateProject() {
		String projectName = "Project";
		LocalDateTime startDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		assertEquals(2, projectManager.getProjects().size());
		projectManager.createProject(place, projectName, startDate, endDate);
		assertEquals(3, projectManager.getProjects().size());
	}

	@Test
	void testCloseProjectFromProjectManager() {
		verify(project, times(0)).closeProject();
		projectManager.closeProject(project);
		verify(project, times(1)).closeProject();
		//FIXME: test private email sender
	}
	
	/*
	 * 12 projects, first 10 are the older ones.
	 */
	@Test
	void testGetTopTenProjectsWithMoreTimeWithoutDonations() {
		//mock projects
		Project pj1  = mock(Project.class);
		Project pj2  = mock(Project.class);
		Project pj3  = mock(Project.class);
		Project pj4  = mock(Project.class);
		Project pj5  = mock(Project.class);
		Project pj6  = mock(Project.class);
		Project pj7  = mock(Project.class);
		Project pj8  = mock(Project.class);
		Project pj9  = mock(Project.class);
		Project pj10 = mock(Project.class);
		Project pj11 = mock(Project.class);
		Project pj12 = mock(Project.class);
		
		//datetimes
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime dt1 = LocalDateTime.parse("2019-08-23 00:00", formatter);
		LocalDateTime dt2 = LocalDateTime.parse("2018-09-24 00:00", formatter);
		LocalDateTime dt3 = LocalDateTime.parse("2018-10-25 00:00", formatter);
		LocalDateTime dt4 = LocalDateTime.parse("2018-11-26 00:00", formatter);
		LocalDateTime dt5 = LocalDateTime.parse("2018-12-27 00:00", formatter);
		LocalDateTime dt6 = LocalDateTime.parse("2020-01-28 00:00", formatter);
		LocalDateTime dt7 = LocalDateTime.parse("2020-02-29 00:00", formatter);
		LocalDateTime dt8 = LocalDateTime.parse("2020-03-30 00:00", formatter);
		LocalDateTime dt9 = LocalDateTime.parse("2020-04-01 00:00", formatter);
		LocalDateTime dt10 = LocalDateTime.parse("2020-05-02 00:00", formatter);
		LocalDateTime dt11 = LocalDateTime.parse("2020-06-03 00:00", formatter);
		LocalDateTime dt12 = LocalDateTime.parse("2020-07-04 00:00", formatter);
		
		//set last donation
		when(pj1.getLastDonationDate()).thenReturn(dt1);
		when(pj2.getLastDonationDate()).thenReturn(dt2);
		when(pj3.getLastDonationDate()).thenReturn(dt3);
		when(pj4.getLastDonationDate()).thenReturn(dt4);
		when(pj5.getLastDonationDate()).thenReturn(dt5);
		when(pj6.getLastDonationDate()).thenReturn(dt6);
		when(pj7.getLastDonationDate()).thenReturn(dt7);
		when(pj8.getLastDonationDate()).thenReturn(dt8);
		when(pj9.getLastDonationDate()).thenReturn(dt9);
		when(pj10.getLastDonationDate()).thenReturn(dt10);
		when(pj11.getLastDonationDate()).thenReturn(dt11);
		when(pj12.getLastDonationDate()).thenReturn(dt12);
		
		List<Project> projectsList = new ArrayList<Project>();
		projectsList.addAll(Arrays.asList(pj8, pj12, pj1, pj3, pj10, pj7, pj6, pj5, pj4, pj9, pj11, pj2));
		
		//add projects to PM
		ProjectManager bigProjectManager = new ProjectManager(projectsList);
		
		assertEquals(12, bigProjectManager.getProjects().size());
		List<Project> oldProjects = bigProjectManager.getTopTenProjectsWithMoreTimeWithoutDonations();
		assertEquals(10, oldProjects.size());
		assertFalse(oldProjects.contains(pj11));
		assertFalse(oldProjects.contains(pj12));
	}
	
	/*
	 * donation amount: 10.0
	 * anotherDonation amount: 10.0
	 */
	@Test
	void testGetTopTenDonations() {
		when(project.getDonations()).thenReturn(projectDonations);
		List<Donation> donations = projectManager.getTopTenDonations();
		assertEquals(anotherDonation, donations.get(0));
		assertEquals(donation, donations.get(1));
		assertEquals(2, donations.size());
	}

}
