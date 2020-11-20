package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.InfoDonationDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IDonationRepo;

@Service
public class DonationService extends AbstractService<Donation, Integer> {
	
	@Autowired
	public DonationService(IDonationRepo repo) { super(repo); }
	
	@Transactional
	public List<InfoDonationDTO> getDonationsFromUser(int id) {
		return this.getAll().stream().filter(donation -> donation.getDonor().getId() == id).map(donation -> new InfoDonationDTO(donation.getPoints(),
				donation.getProjectName(), donation.getAmount(), donation.getDate().toString())).collect(Collectors.toList());
	}
}