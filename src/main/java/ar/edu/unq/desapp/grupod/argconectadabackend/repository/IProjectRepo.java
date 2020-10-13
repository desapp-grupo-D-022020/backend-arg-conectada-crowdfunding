package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;

public interface IProjectRepo extends JpaRepository<Project, Integer> {}