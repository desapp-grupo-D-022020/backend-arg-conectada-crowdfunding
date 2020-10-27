package ar.edu.unq.desapp.grupod.argconectadabackend.validations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ar.edu.unq.desapp.grupod.argconectadabackend.enums.RolName;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Rol;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;

@DataJpaTest
public class UserValidationTest {

    
    private Validator validator;
    
    
    @Test
    public void persistNewUserWithoutNameRaisesException() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    	
        Rol rol = new Rol();
        rol.setRolName(RolName.ROLE_USER);
        rol.setId((long) 2);
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        
    	User user = new User("","12345678","asd@gmail.com","nickname");
    	user.setRoles(roles);
    	
    	Set<ConstraintViolation<User>> violations = validator.validate(user);
    	assertThat(violations.size()).isEqualTo(2);	
    }
    
    @Test
    public void persistNewUserWithoutEmailRaisesException() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    	
        Rol rol = new Rol();
        rol.setRolName(RolName.ROLE_USER);
        rol.setId((long) 2);
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        
    	User user = new User("aName","12345678","","nickname");
    	user.setRoles(roles);
    	
    	Set<ConstraintViolation<User>> violations = validator.validate(user);
    	assertThat(violations.size()).isEqualTo(1);	
    }
    
    @Test
    public void persistNewUserWithoutPasswordRaisesException() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        Rol rol = new Rol();
        rol.setRolName(RolName.ROLE_USER);
        rol.setId((long) 2);
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        
    	User user = new User("aName","","asd@gmail.com","nickname");
    	user.setRoles(roles);
    	
    	Set<ConstraintViolation<User>> violations = validator.validate(user);
    	assertThat(violations.size()).isEqualTo(2);	
    }
    
    @Test
    public void persistNewUserWithShortPasswordRaisesException() {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        
        Rol rol = new Rol();
        rol.setRolName(RolName.ROLE_USER);
        rol.setId((long) 2);
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        
    	User user = new User("aName","1234567","asd@gmail.com","nickname");
    	user.setRoles(roles);
    	
    	Set<ConstraintViolation<User>> violations = validator.validate(user);
    	assertThat(violations.size()).isEqualTo(1);	
    }
    
}
