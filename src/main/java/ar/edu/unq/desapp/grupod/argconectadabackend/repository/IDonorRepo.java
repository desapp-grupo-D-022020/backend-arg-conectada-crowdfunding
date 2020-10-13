package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donor;

public interface IDonorRepo extends JpaRepository<Donor, Integer> {}