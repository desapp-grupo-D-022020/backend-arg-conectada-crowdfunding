package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;

@Repository
public interface IDonationRepo extends IRepo<Donation, Integer> {}