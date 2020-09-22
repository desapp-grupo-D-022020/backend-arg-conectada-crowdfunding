package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CrowdfoundingManagerTest {
	
	@Test
	void testCrowdfoundingManagerConstructor() {
		List<Place> places = new ArrayList<Place>();
		List<Donor> donors = new ArrayList<Donor>();
		
		CrowdFundingManager cfmanager = new CrowdFundingManager(places, donors);
		assertEquals(places, cfmanager.getPlaces());
		assertEquals(donors, cfmanager.getUsers());
	}
	
	@Test
	void testGetOpenProjectsCallsMethod() {
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.getOpenProjects();
		verify(projectManager, times(1)).getOpenProjects();
	}
	
	@Test
	void testGetNearlyClosedProjectsCallsMethod() {		
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.getNearlyCloseProjects();
		verify(projectManager, times(1)).getNearlyClosedProjects();
	}
	
	@Test
	void testGetProjectCallsMethod() {		
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		Place place = mock(Place.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.getProject(place);
		verify(projectManager, times(1)).getProject(place);
	}
	
	@Test
	void testGetCostCallsMethod() {		
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		Place place = mock(Place.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.getCost(place);
		verify(projectManager, times(1)).getCost(place);
	}
	
	@Test
	void testGetTopTenProjectsCallsMethod() {		
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.topTenProjectsWithMoreTimeWithoutDonations();
		verify(projectManager, times(1)).getTopTenProjectsWithMoreTimeWithoutDonations();
	}
	
	@Test
	void testGetTopTenDonationsCallsMethod() {		
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		cfmanager.setProjectManager(projectManager);
		
		cfmanager.topTenDonations();
		verify(projectManager, times(1)).getTopTenDonations();
	}
	
	// Getters and Setters
	
	@Test
	void testGetSetPlaces() {
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		List<Place> places = new ArrayList<Place>();
		places.add(new Place("aPlaceName","aProvinceName",500,"not connected"));
		
		cfmanager.setPlaces(places);
		assertEquals(cfmanager.getPlaces(),places);
	}
	
	@Test
	void testGetSetProjectManager() {
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		ProjectManager projectManager = mock(ProjectManager.class);
		
		cfmanager.setProjectManager(projectManager);
		assertEquals(cfmanager.getProjectManager(),projectManager);
	}
	
	@Test
	void testGetSetUsers() {
		CrowdFundingManager cfmanager = new CrowdFundingManager();
		List<Donor> donors = new ArrayList<Donor>();
		donors.add(mock(Donor.class));
		
		cfmanager.setUsers(donors);
		assertEquals(cfmanager.getUsers(),donors);
	}

}
