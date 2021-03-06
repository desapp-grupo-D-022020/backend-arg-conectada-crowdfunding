package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectTest {
	
	private Project project;
	private String projectName;
	private User donor;
	private Place place;
	private Place anotherPlace;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private DateTimeFormatter formatter;
	
	@Test
	void testGetName() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(projectName, project.getName());
	}

	@Test
	void testSetName() {
		
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);

		String anotherProjectName = "Another project name";
		
		assertNotEquals(anotherProjectName, project.getName());
		project.setName(anotherProjectName);
		assertEquals(anotherProjectName, project.getName());
	}
	
	@Test
	void testGetPlace() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(project.getPlace(), place);
	}

	@Test
	void testSetPlace() {
		
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		anotherPlace = mock(Place.class);
		
		assertNotEquals(anotherPlace, project.getPlace());
		project.setPlace(anotherPlace);
		assertEquals(anotherPlace, project.getPlace());
	}
	
	@Test
	void testGetDefaultFactor() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(1_000, project.getFactor());
	}

	@Test
	void testSetFactor() {
		
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		double anotherProjectFactor = 500.0;

		assertNotEquals(anotherProjectFactor, project.getFactor());
		project.setFactor(anotherProjectFactor);
		assertEquals(anotherProjectFactor, project.getFactor());
	}

	@Test
	void testGetPercentageForClose() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(100.0, project.getPercentageForClose());
	}

	@Test
	void testSetPercentageForClose() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		double anotherProjectPercentageForClose= 80.0;

		assertNotEquals(anotherProjectPercentageForClose, project.getPercentageForClose());
		project.setPercentageForClose(anotherProjectPercentageForClose);
		assertEquals(anotherProjectPercentageForClose, project.getPercentageForClose());
	}

	@Test
	void testGetStartDate() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(startDate, project.getStartDate());
	}

	@Test
	void testSetStartDate() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		LocalDateTime anotherStartDate = LocalDateTime.parse("2020-09-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertNotEquals(anotherStartDate, project.getStartDate());
		project.setStartDate(anotherStartDate);
		assertEquals(anotherStartDate, project.getStartDate());
	}

	@Test
	void testGetEndDate() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(endDate, project.getEndDate());
	}

	@Test
	void testSetEndDate() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		LocalDateTime anotherEndDate = LocalDateTime.parse("2021-12-25 00:00", formatter);
		
		assertNotEquals(anotherEndDate, project.getEndDate());
		project.setEndDate(anotherEndDate);
		assertEquals(anotherEndDate, project.getEndDate());
	}
	
	@Test
	void testGetDonorsReturnsZeroIfEmpty() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(0, project.getDonors().size());
	}
	
	@Test
	void testGetDonorsReturnListOfDonorsCorrectly() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		List<Donation> donations = new ArrayList<Donation>();
		Donation testDonation1 = mock(Donation.class);
		Donation testDonation2 = mock(Donation.class);
		
		donations.add(testDonation1);
		donations.add(testDonation2);
		project.setDonations(donations);
		
		
		int numberOfDonors = project.getDonors().size();
		assertEquals(2, numberOfDonors);
		
	}

	@Test
	void testGetDonations() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(0, project.getDonations().size());
	}

	@Test
	void testSetDonations() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		List<Donation> donations = new ArrayList<Donation>();
		Donation testDonation1 = mock(Donation.class);
		Donation testDonation2 = mock(Donation.class);
		donations.add(testDonation1);
		donations.add(testDonation2);
		
		assertEquals(0, project.getDonations().size());
		project.setDonations(donations);
		assertEquals(2, project.getDonations().size());
	}

	@Test
	void testGetCost() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		when(place.getPopulation()).thenReturn(5_000);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertEquals(5_000_000, project.getCost());
	}
	
	@Test
	void testGetPlacePopulation() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		when(place.getPopulation()).thenReturn(5_000);
		
		verify(place, times(0)).getPopulation();
		project.getPlacePopulation();
		verify(place, times(1)).getPopulation();
	}
	
	@Test
	void testReceiveDonation() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2099-08-23 00:00", formatter);
		project = new Project(place, projectName, startDate, endDate);
		double amount = 15.0;
		String commentary = "No Comments";

		project.receiveDonation(donor, amount, commentary);
		
		assertEquals(1, project.getDonations().size());
	}

	@Test
	void testGetLastDonation() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		List<Donation> donations = new ArrayList<Donation>();
		Donation testDonation1 = mock(Donation.class);
		Donation testDonation2 = mock(Donation.class);
		when(testDonation2.getAmount()).thenReturn(100.0);
		donations.add(testDonation1);
		donations.add(testDonation2);
		
		assertEquals(0, project.getDonations().size());
		project.setDonations(donations);
		assertEquals(testDonation2, project.getLastDonation());
	}
	
	@Test
	void testGetLastDonationDate() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		List<Donation> donations = new ArrayList<Donation>();
		Donation testDonation1 = mock(Donation.class);
		Donation testDonation2 = mock(Donation.class);
		LocalDateTime donationDate = LocalDateTime.now();
		
		when(testDonation2.getDate()).thenReturn(donationDate);
		donations.add(testDonation1);
		donations.add(testDonation2);
		
		assertEquals(0, project.getDonations().size());
		project.setDonations(donations);
		assertEquals(donationDate, project.getLastDonationDate());
		
	}

	@Test
	void testCloseProject() {
		place = mock(Place.class);
		projectName = "testProject";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		
		project = new Project(place, projectName, startDate, endDate);
		
		assertTrue(project.isOpen());
		project.closeProject();
		assertFalse(project.isOpen());
	}
	
	@Test
	void testHasDonationOnCurrentMonth() {
		place = mock(Place.class);
		projectName = "testProjectWithDonationsOnCurrentMonth";
		startDate = LocalDateTime.now();
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		endDate = LocalDateTime.parse("2099-08-23 00:00", formatter);
		
		LocalDateTime donationDate = LocalDateTime.now();
		
		Donation testDonation = mock(Donation.class);
		when(testDonation.getDate()).thenReturn(donationDate);
		List<Donation> donations = new ArrayList<Donation>();
		when(testDonation.isWithinCalendarMonth()).thenReturn(true);
		donations.add(testDonation);

		
		
		project = new Project(place, projectName, startDate, endDate);
		project.setDonations(donations);
		
		assertTrue(project.hasDonationsOnCurrentMonth());
	}

}
