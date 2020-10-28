package ar.edu.unq.desapp.grupod.argconectadabackend.validations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;

public class PlaceValidationTest {
	
	private Validator validator;
	
	@Test
    public void newPlaceWithoutNameRaisesError() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    	
        Place place = new Place("", "aProvince", 1000, "connected");
        
    	
    	Set<ConstraintViolation<Place>> violations = validator.validate(place);
    	assertThat(violations.size()).isEqualTo(1);	
    }
	
	@Test
    public void newPlaceWithoutProvinceRaisesError() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    	
        Place place = new Place("aName", "", 1000, "connected");
        
    	
    	Set<ConstraintViolation<Place>> violations = validator.validate(place);
    	assertThat(violations.size()).isEqualTo(1);	
    }
	
	@Test
    public void newPlaceWithoutStautsRaisesError() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    	
        Place place = new Place("", "aProvince", 1000, "connected");
        
    	
    	Set<ConstraintViolation<Place>> violations = validator.validate(place);
    	assertThat(violations.size()).isEqualTo(1);	
    }
}
