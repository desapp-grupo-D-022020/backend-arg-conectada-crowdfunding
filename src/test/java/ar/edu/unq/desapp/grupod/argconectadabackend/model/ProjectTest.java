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
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	@BeforeEach
	void setUp() {
		projectName = "testProject";
		donor = mock(Donor.class);
		place = mock(Place.class);
		when(place.getPopulation()).thenReturn(5_000);
		
		startDate = LocalDateTime.now();
		endDate = LocalDateTime.parse("2021-08-23 00:00", formatter);
		project = new Project(place, projectName, startDate, endDate);
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
/* TODO: no va mas el place en project?
	@Test
	void testGetPlace() {
		assertEquals(project.getPlace(), place);
	}

	@Test
	void testSetPlace() {
		fail("Not yet implemented");
	}
*/
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
	/*FIXME
	@Test
	void testGetPlacePopulation() {
		verify(place, times(0)).getPopulation();
		project.getPlacePopulation();
		verify(place, times(1)).getPopulation();
	}
	*/

	@Test
	void testReceiveDonation() {
		/*
		fail("Not yet implemented");
		//TODO: test create Donation?
		verify(project, times(0)).addDonation();
		verify(project, times(0)).addDonor();
		verify(pointsManager, times(0)).(assignPoints());
		project.getPlacePopulation();
		verify(place, times(1)).getPopulation();
		 */		
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
	void testIsOpen() {
		//fail("Not yet implemented");
	}

	@Test
	void testCloseProject() {
		assertTrue(project.isOpen());
		project.closeProject();
		assertFalse(project.isOpen());
	}

}
