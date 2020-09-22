package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class PointsManagerTest {
	
	private PointsManager pm;
	private double smallAmount = 500;
    private double bigAmount = 5_000;
    
    private Donor donor;
	private Place place;
	
    private Project projectWithDonationInCurrentMonthAndSmallPopulation;
    private Project projectWithoutDonationInCurrentMonthAndSmallPopulation;
    private Project projectWithDonationInCurrentMonthAndBigPopulation;
    private Project projectWithoutDonationInCurrentMonthAndBigPopulation;
    
    private Donation donationInCurrentMonth;
    private Donation donationInOlderMonth;
    
    //FIXME: esto me parece no va
    //private RewardProgram rewardProgram;

	
	@BeforeEach
	void setUp() {
		donor = mock(Donor.class);
		place = mock(Place.class);
		
		projectWithDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		projectWithoutDonationInCurrentMonthAndSmallPopulation = mock(Project.class);
		projectWithDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		projectWithoutDonationInCurrentMonthAndBigPopulation = mock(Project.class);
		
		donationInCurrentMonth = mock(Donation.class);
		donationInOlderMonth = mock(Donation.class);
		
		when(donor.getPoints()).thenReturn(0.0);
		when(place.getPopulation()).thenReturn(100_000);
		when(donationInCurrentMonth.isWithinCalendarMonth()).thenReturn(true);
		when(donationInOlderMonth.isWithinCalendarMonth()).thenReturn(false);
		
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getLastDonation()).thenReturn(donationInCurrentMonth);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.getLastDonation()).thenReturn(donationInOlderMonth);
		when(projectWithDonationInCurrentMonthAndBigPopulation.getLastDonation()).thenReturn(donationInCurrentMonth);
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.getLastDonation()).thenReturn(donationInOlderMonth);
		
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(1_000);
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.getPlacePopulation()).thenReturn(500);
		when(projectWithDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(200_000);
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.getPlacePopulation()).thenReturn(500_000);
		
		when(projectWithDonationInCurrentMonthAndSmallPopulation.getName()).thenReturn("Small Project");
		when(projectWithoutDonationInCurrentMonthAndSmallPopulation.getName()).thenReturn("Small Project");
		when(projectWithDonationInCurrentMonthAndBigPopulation.getName()).thenReturn("Big Project");
		when(projectWithoutDonationInCurrentMonthAndBigPopulation.getName()).thenReturn("Big Project");
		
		pm = new PointsManager();
	}
	
	@AfterEach
    void tearDown() {
		donor = null;
        place = null;
        //TODO y asi con todas las clases mockeadas
    }
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 10_000 pts (small population)
	 * rule 3: 500 pts (recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForBigDonationOnSmallPopulationRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(2 * bigAmount, calculatedPoints.get(1));
		assertEquals(500.0, calculatedPoints.get(2));
		assertEquals(3, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 10_000 pts (small population)
	 * rule 3: 0 pts (non-recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForBigDonationOnSmallPopulationNonRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndSmallPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(2 * bigAmount, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 1_000 pts (small population)
	 * rule 3: 500 pts (recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForSmallDonationOnSmallPopulationRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, smallAmount);
		assertEquals(2 * smallAmount, calculatedPoints.get(0));
		assertEquals(500.0, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 1_000 pts (small population)
	 * rule 3: 0 pts (non-recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForSmallDonationOnSmallPopulationNonRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndSmallPopulation, smallAmount);
		assertEquals(2 * smallAmount, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 500 pts (recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForSmallDonationOnBigPopulationRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithDonationInCurrentMonthAndBigPopulation, smallAmount);
		assertEquals(500.0, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	/* rule 1: 0 pts (small donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 0 pts (non-recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForSmallDonationOnBigPopulationNonRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndBigPopulation, smallAmount);
		assertEquals(0, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 500 pts (recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForBigDonationOnBigPopulationRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithDonationInCurrentMonthAndBigPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(500.0, calculatedPoints.get(1));
		assertEquals(2, calculatedPoints.size());
	}
	
	/* rule 1: 5_000 pts (big donation)
	 * rule 2: 0 pts (big population)
	 * rule 3: 0 pts (non-recurring contributor)
	 * 
	*/
	@Test
	void testCalculatePointsForBigDonationOnBigPopulationNonRecurringContributor() {
		List<Double> calculatedPoints = pm.calculatePoints(donor, projectWithoutDonationInCurrentMonthAndBigPopulation, bigAmount);
		assertEquals(bigAmount, calculatedPoints.get(0));
		assertEquals(1, calculatedPoints.size());
	}
	
	
	@Test
	void testSumPoints() {
		List<Double> pointsList = new ArrayList<Double>();
		pointsList.add(100.0);
		pointsList.add(50.0);
		
		Double result = pm.sumPoints(pointsList);
		assertEquals(150.0, result);
	}
	
	@Test
	void testAssignPointsFromBigDonationToSmallPopulation() {
		String projectName = projectWithDonationInCurrentMonthAndSmallPopulation.getName();
		Double points = pm.sumPoints(pm.calculatePoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount));
		
		pm.assignPoints(donor, projectWithDonationInCurrentMonthAndSmallPopulation, bigAmount);
		verify(donor, times(1)).addPointsToRegister(projectName, points);
	}

}
