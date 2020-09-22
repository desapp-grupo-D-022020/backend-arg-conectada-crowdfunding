package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectTest {
	
	private Project project;
	private String projectName;
	private Donor donor;
	private Place place;
	private Place anotherPlace;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private PointsManager pointsManager;
	
	@BeforeEach
	void setUp() {
		projectName = "testProject";
		donor = mock(Donor.class);
		when(donor.getNickName()).thenReturn("aNickName");
		place = mock(Place.class);
		anotherPlace = mock(Place.class);
		when(place.getPopulation()).thenReturn(5_000);
		
		startDate = LocalDateTime.now();
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		project = new Project(place, projectName, startDate, endDate);
		
		pointsManager = mock(PointsManager.class);
	}
	
	@AfterEach
    void tearDown() {
        project = null;
    }
	

	@Test
	void testGetName() {
		assertEquals(projectName, project.getName());
	}

	@Test
	void testSetName() {
		String anotherProjectName = "Another project name";

		assertNotEquals(anotherProjectName, project.getName());
		project.setName(anotherProjectName);
		assertEquals(anotherProjectName, project.getName());
	}
	
	@Test
	void testGetPlace() {
		assertEquals(project.getPlace(), place);
	}

	@Test
	void testSetPlace() {
		assertNotEquals(anotherPlace, project.getPlace());
		project.setPlace(anotherPlace);
		assertEquals(anotherPlace, project.getPlace());
	}
	
	@Test
	void testGetDefaultFactor() {
		assertEquals(1_000, project.getFactor());
	}

	@Test
	void testSetFactor() {
		double anotherProjectFactor = 500.0;

		assertNotEquals(anotherProjectFactor, project.getFactor());
		project.setFactor(anotherProjectFactor);
		assertEquals(anotherProjectFactor, project.getFactor());
	}

	@Test
	void testGetPercentageForClose() {
		assertEquals(100.0, project.getPercentageForClose());
	}

	@Test
	void testSetPercentageForClose() {
		double anotherProjectPercentageForClose= 80.0;

		assertNotEquals(anotherProjectPercentageForClose, project.getPercentageForClose());
		project.setPercentageForClose(anotherProjectPercentageForClose);
		assertEquals(anotherProjectPercentageForClose, project.getPercentageForClose());
	}

	@Test
	void testGetStartDate() {
		//FIXME: este test puede fallar si se demora en llegar desde el @Before
		assertEquals(startDate, project.getStartDate());
	}

	@Test
	void testSetStartDate() {
		LocalDateTime anotherStartDate = LocalDateTime.parse("2020-09-23 00:00", formatter);
		
		assertNotEquals(anotherStartDate, project.getStartDate());
		project.setStartDate(anotherStartDate);
		assertEquals(anotherStartDate, project.getStartDate());
	}

	@Test
	void testGetEndDate() {
		assertEquals(endDate, project.getEndDate());
	}

	@Test
	void testSetEndDate() {
		LocalDateTime anotherEndDate = LocalDateTime.parse("2021-12-25 00:00", formatter);
		
		assertNotEquals(anotherEndDate, project.getEndDate());
		project.setEndDate(anotherEndDate);
		assertEquals(anotherEndDate, project.getEndDate());
	}

	@Test
	void testGetDonations() {
		assertEquals(0, project.getDonations().size());
	}

	@Test
	void testSetDonations() {
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
		assertEquals(5_000_000, project.getCost());
	}
	
	@Test
	void testGetPlacePopulation() {
		verify(place, times(0)).getPopulation();
		project.getPlacePopulation();
		verify(place, times(1)).getPopulation();
	}
	
	/*
	 * private method
	@Test
	void testAssignPointsToUser() {
		double amount = 10.0;
		project.setPointsManager(pointsManager);
		verify(pointsManager, times(0)).assignPoints(donor, project, amount);
		project.assignPointsToUser(donor, project, amount);
		verify(pointsManager, times(1)).assignPoints(donor, project, amount);
	}
	*/
	
	@Test
	void testReceiveDonation() {
		double amount = 15.0;
		String commentary = "No Comments";
		project.setPointsManager(pointsManager);

		verify(pointsManager, times(0)).assignPoints(donor, project, amount);
		project.receiveDonation(donor, amount, commentary);
		verify(pointsManager, times(1)).assignPoints(donor, project, amount);
		assertEquals(1, project.getDonors().size());
		assertEquals(donor, project.getDonors().get(0));
		assertEquals(1, project.getDonations().size());
	}

	@Test
	void testGetLastDonation() {
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
	void testGetLastDoinationDate() {
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

	//TODO: testear algo que devuelve un bool?
	@Test
	void testIsOpen() {
	}

	@Test
	void testCloseProject() {
		assertTrue(project.isOpen());
		project.closeProject();
		assertFalse(project.isOpen());
	}

}
