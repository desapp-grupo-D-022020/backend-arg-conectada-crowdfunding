package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;

public interface IDonationRepo extends JpaRepository<Donation, Integer> {}