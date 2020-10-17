package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Integer> {}