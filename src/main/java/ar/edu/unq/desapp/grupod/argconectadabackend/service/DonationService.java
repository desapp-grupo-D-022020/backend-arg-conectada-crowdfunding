package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IDonationRepo;

@Service
public class DonationService extends AbstractService<Donation, Integer> {
	
	@Autowired
	public DonationService(IDonationRepo repo) { super(repo); }
	
	public List<Donation> getDonationsFromUser(int id) {
		return repo.findAll().stream().filter(donation -> donation.getDonor().getId() == id).collect(Collectors.toList());
	}
}