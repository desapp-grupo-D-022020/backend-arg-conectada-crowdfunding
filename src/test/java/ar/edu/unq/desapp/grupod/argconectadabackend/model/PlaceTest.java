package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PlaceTest {
	
	private Place place;
    private String placeName = "Quilmes";
    private String provinceName = "Buenos Aires";
    private Integer population = 580_829;
    private String status = "Disconnected";
    private String connectedStatus = "Connected";
	
	@BeforeEach
	void setUp() {
		place = new Place(placeName, provinceName, population, status);
	}
	
	@AfterEach
    void tearDown() {
        place = null;
    }
	
	
	@Test
	void testGetPlaceName() {
		assertEquals(place.getName(), placeName);
	}
	
	@Test
	void testGetProvinceName() {
		assertEquals(place.getProvince(), provinceName);
	}
	
	@Test
	void testGetPopulation() {
		assertEquals(place.getPopulation(), population);
	}
	
	@Test
	void testGetCorrectStatus() {
		assertEquals(place.getStatus(), status);
	}
	
	
	@Test
	void testSetPlaceNameToAnother() {
	    String anotherPlaceName = "Ceibas";

		assertNotEquals(place.getName(), anotherPlaceName);
		place.setName(anotherPlaceName);
		assertEquals(place.getName(), anotherPlaceName);
	}
	
	@Test
	void testSetProvinceNameToAnother() {
	    String anotherProvinceName = "Entre Rios";

		assertNotEquals(place.getProvince(), anotherProvinceName);
		place.setProvince(anotherProvinceName);
		assertEquals(place.getProvince(), anotherProvinceName);
	}
	
	@Test
	void testSetPopulationToAnother() {
		Integer anotherPopulation = 1_773;

		assertNotEquals(place.getPopulation(), anotherPopulation);
		place.setPopulation(anotherPopulation);
		assertEquals(place.getPopulation(), anotherPopulation);
	}
	
	@Test
	void testSetStatusToAnother() {
		assertNotEquals (place.getStatus(), connectedStatus);
		
		place.setStatus(connectedStatus);
		assertEquals(place.getStatus(), connectedStatus);
	}
	
	
}
