package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;

@Repository
public interface IProjectRepo extends IRepo<Project, Integer> {}