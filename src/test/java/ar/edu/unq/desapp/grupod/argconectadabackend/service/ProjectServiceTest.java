package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.DonationDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.ProjectDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IProjectRepo;


@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTest {
	
	@InjectMocks
	private ProjectService projectService;
	
	@Mock
	private IProjectRepo projectRepository;
	
	@Mock
	private PointsManagerService pointManagerService;
	
	@Test
	void testCreateProjectCallsRepositorySave() {
		MockitoAnnotations.initMocks(this);
		ProjectDto projectDto = mock(ProjectDto.class);
		
		projectService.createProject(projectDto);
		
		verify(projectRepository).save(any(Project.class));
		
	}
	
	@Test
	void testCloseProjectCallsRepositorySave() {
		MockitoAnnotations.initMocks(this);
		ProjectDto projectDto = mock(ProjectDto.class);		
		Project project = mock(Project.class);
		projectService.createProject(projectDto);
		when(projectService.getById(anyInt())).thenReturn(project);
		
		projectService.closeProject(0);

		verify(projectRepository, times(2)).save(any(Project.class));
	}
	
	@Test
	void testCloseProjectCallsProjectMethod() {
		MockitoAnnotations.initMocks(this);
		ProjectDto projectDto = mock(ProjectDto.class);
		Project project = mock(Project.class);
		projectService.createProject(projectDto);
		when(projectService.getById(anyInt())).thenReturn(project);		

		projectService.closeProject(0);
		
		verify(project).closeProject();
	}
	
	@Test
	void testGetOpenProjectsCallsRepoFindAll() {
		MockitoAnnotations.initMocks(this);
		
		projectService.getOpenProjects();
		
		verify(projectRepository).findAll();
	}
	
	@Test
	void testGetNearlyClosedProjectsCallsRepoFindAll() {
		MockitoAnnotations.initMocks(this);
		
		projectService.getNearlyClosedProjects();
		
		verify(projectRepository).findAll();
	}
	
	@Test
	void testGetCostCallsRepoAndProjectMethods() {
		MockitoAnnotations.initMocks(this);
		Project project = mock(Project.class);
		when(projectService.getById(anyInt())).thenReturn(project);	
		
		projectService.getCost(1);
		
		verify(projectRepository).getOne(anyInt());
		verify(project).getCost();
		
	}
	
	@Test
	void testDonateCallsRepoSaveAndProjectReceiveDonation() throws NoSuchFieldException, SecurityException {
		MockitoAnnotations.initMocks(this);
		
		User anyUser = mock(User.class);
		DonationDto donationDto = new DonationDto();
		donationDto.setUser(anyUser);
		donationDto.setAmount(1_000);
		donationDto.setCommentary("aCommentary");
		
		PointsManagerService pointsManager = mock(PointsManagerService.class);
		FieldSetter.setField(projectService, projectService.getClass().getDeclaredField("pointsManager"), pointsManager);	
		Project project = mock(Project.class);
		when(projectService.getById(anyInt())).thenReturn(project);
		Mockito.doNothing().when(this.pointManagerService).assignPoints(any(User.class), any(Project.class), any(Double.class));
		
		projectService.donate(donationDto);
		
		verify(projectRepository).save(any(Project.class));
		verify(project).receiveDonation(any(User.class), any(Double.class), anyString());
	}
	
	@Test
	void testGetTopTenProjectsWithMoreTimeWithoutDonationsCallsRepoFindAll() {
		MockitoAnnotations.initMocks(this);
		
		projectService.getTopTenProjectsWithMoreTimeWithoutDonations();
		
		verify(projectRepository).findAll();
	}
	
	@Test
	void testGetTopTenDonationsCallsRepoFindAll() {
		MockitoAnnotations.initMocks(this);
		
		projectService.getTopTenDonations();
		
		verify(projectRepository).findAll();
	}

}
