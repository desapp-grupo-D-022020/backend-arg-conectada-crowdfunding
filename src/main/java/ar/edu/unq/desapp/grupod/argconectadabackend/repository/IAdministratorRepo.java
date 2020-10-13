package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Administrator;

public interface IAdministratorRepo extends JpaRepository<Administrator, Integer> {}