package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	
	@BeforeEach
	void setUp() {
		projectName = "testProject";
		donor = mock(Donor.class);
		place = mock(Place.class);
		startDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
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
	void testGetFactor() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFactor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPercentageForClose() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPercentageForClose() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStartDate() {
		fail("Not yet implemented");
	}

	@Test
	void testSetStartDate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEndDate() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEndDate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDonations() {
		fail("Not yet implemented");
	}

	@Test
	void testSetDonations() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCost() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlacePopulation() {
		fail("Not yet implemented");
	}

	@Test
	void testReceiveDonation() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLastDonation() {
		fail("Not yet implemented");
	}

	@Test
	void testIsOpen() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseProject() {
		fail("Not yet implemented");
	}

}
