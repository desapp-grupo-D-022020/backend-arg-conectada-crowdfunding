package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectManagerTest {
	
	private ProjectManager projectManager;
	private List<Project> projects;
	private List<Project> anotherProjects;
	private Project project;
	private Project projectTwo;
	private Project testProject1;
	private Place place;
	private Place anotherPlace;
	
	@BeforeEach
	void setUp() {
		place = mock(Place.class);
		anotherPlace = mock(Place.class);
		project = mock(Project.class);
		projectTwo = mock(Project.class);
		testProject1 = mock(Project.class);
		
		projects = new ArrayList<Project>();
		projects.add(project);
		projects.add(projectTwo);
		when(project.getPlace()).thenReturn(place);
		when(projectTwo.getPlace()).thenReturn(anotherPlace);
		
		anotherProjects = new ArrayList<Project>();
		anotherProjects.add(testProject1);
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
	@Test
	void testGetOpenProjects() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNearlyCloseProjects() {
		fail("Not yet implemented");
	}
*/
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
/*
	@Test
	void testCreateProject() {
		fail("Not yet implemented");
	}

	@Test
	void testCloseProject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTopTenProjectsWithMoreTimeWithoutDonations() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTopTenDonations() {
		fail("Not yet implemented");
	}
*/
}
