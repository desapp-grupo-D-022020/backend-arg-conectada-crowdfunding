package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    
	Optional<User> findByName(String nu);
    
    boolean existsByName(String nu);
    
    boolean existsByEmail(String email);
}