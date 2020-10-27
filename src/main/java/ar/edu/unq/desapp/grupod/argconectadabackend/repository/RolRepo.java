package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.enums.RolName;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Rol;

@Repository
public interface RolRepo extends JpaRepository<Rol, Long> {
	
    Optional<Rol> findByRolName(RolName rolName);

}