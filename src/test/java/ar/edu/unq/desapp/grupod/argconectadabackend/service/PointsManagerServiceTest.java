package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;

@RunWith(MockitoJUnitRunner.class)
public class PointsManagerServiceTest {
	
	@InjectMocks
	private PointsManagerService pointsManager;
	
	@Mock
	private UserService userService;
	
	private double smallAmount = 500;
    private double bigAmount = 5_000;
    
    private User donor;
	
    private Project projectWithDonationInCurrentMonthAndSmallPopulation;
    private Project projectWithoutDonationInCurrentMonthAndSmallPopulation;
    private Project projectWithDonationInCurrentMonthAndBigPopulation;
    private Project projectWithoutDonationInCurrentMonthAndBigPopulation;
    
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 10_000 pts (small population)
	 * rule 3: 500 pts (recurring contributor)
	 */
	@Test
	void testCalculatePointsForBigDonationOnSmallPopulationRecurringContributor() {
		projectWithDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(1_000);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.hasDonationsOnCurrentMonth()).thenReturn(true);
		
		pointsManager = new PointsManagerService();
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(2 * bigAmount, calculatedPoints.get(1));
		assertEquals(500.0, calculatedPoints.get(2));
		assertEquals(3, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 10_000 pts (small population)
	 * rule 3: 0 pts (non-recurring contributor)
	 */
	@Test
	void testCalculatePointsForBigDonationOnSmallPopulationNonRecurringContributor() {
		projectWithoutDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.hasDonationsOnCurrentMonth()).thenReturn(false);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(500);
		donor = mock(User.class);
		when(donor.getPoints()).thenReturn(0.0);
		
		pointsManager = new PointsManagerService();
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndSmallPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(2 * bigAmount, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 1_000 pts (small population)
	 * rule 3: 500 pts (recurring contributor)
	 */
	@Test
	void testCalculatePointsForSmallDonationOnSmallPopulationRecurringContributor() {
		projectWithDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.hasDonationsOnCurrentMonth()).thenReturn(true);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(1_000);
		donor = mock(User.class);
		when(donor.getPoints()).thenReturn(0.0);
		
		pointsManager = new PointsManagerService();
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, smallAmount);
		assertEquals(2 * smallAmount, calculatedPoints.get(0));
		assertEquals(500.0, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 1_000 pts (small population)
	 * rule 3: 0 pts (non-recurring contributor)
	 */
	@Test
	void testCalculatePointsForSmallDonationOnSmallPopulationNonRecurringContributor() {
		projectWithoutDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.hasDonationsOnCurrentMonth()).thenReturn(false);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(500);
		donor = mock(User.class);
		when(donor.getPoints()).thenReturn(0.0);
		
		pointsManager = new PointsManagerService();
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndSmallPopulation, smallAmount);
		assertEquals(2 * smallAmount, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 500 pts (recurring contributor)
	 */
	@Test
	void testCalculatePointsForSmallDonationOnBigPopulationRecurringContributor() {
		pointsManager = new PointsManagerService();
		donor = mock(User.class);
		projectWithDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		when(projectWithDonationInCurrentMonthAndBigPopulation.hasDonationsOnCurrentMonth()).thenReturn(true);
		when(projectWithDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(200_000);
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithDonationInCurrentMonthAndBigPopulation, smallAmount);
		assertEquals(500.0, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 0 pts (non-recurring contributor)
	 */
	@Test
	void testCalculatePointsForSmallDonationOnBigPopulationNonRecurringContributor() {
		pointsManager = new PointsManagerService();
		donor = mock(User.class);
		projectWithoutDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.hasDonationsOnCurrentMonth()).thenReturn(false);
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(500_000);
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndBigPopulation, smallAmount);
		assertEquals(0, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 500 pts (recurring contributor)
	 */
	@Test
	void testCalculatePointsForBigDonationOnBigPopulationRecurringContributor() {
		pointsManager = new PointsManagerService();
		donor = mock(User.class);
		projectWithDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		when(projectWithDonationInCurrentMonthAndBigPopulation.hasDonationsOnCurrentMonth()).thenReturn(true);
		when(projectWithDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(200_000);
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithDonationInCurrentMonthAndBigPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(500.0, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 0 pts (non-recurring contributor)
	 */
	@Test
	void testCalculatePointsForBigDonationOnBigPopulationNonRecurringContributor() {
		pointsManager = new PointsManagerService();
		donor = mock(User.class);
		projectWithoutDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(500_000);
		
		List<Double> calculatedPoints = pointsManager.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndBigPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	
	@Test
	void testSumPointsCorrectly() {
		pointsManager = new PointsManagerService();
		
		List<Double> pointsList = new ArrayList<Double>();
		pointsList.add(100.0);
		pointsList.add(50.0);
		
		Double result = pointsManager.sumPoints(pointsList);
		assertEquals(150.0, result);
	}
	
	/*@Test
	void testAssignPointsCallsCalculatePoints() {
		projectWithDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.hasDonationsOnCurrentMonth()).thenReturn(true);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(1_000);
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getName()).thenReturn("aName");
		
		donor = mock(User.class);
		when(donor.getPoints()).thenReturn(0.0);
		doCallRealMethod().when(donor).addPointsToRegister(anyString(), anyDouble());
		
		
		pointsManager = mock(PointsManagerService.class);
		doCallRealMethod().when(pointsManager).assignPoints(any(User.class), any(Project.class), anyDouble());
		pointsManager.assignPoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount);
		
		
		verify(pointsManager, times(1)).calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount);
	}*/

}
