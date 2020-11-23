package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.InfoDonationDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IDonationRepo;

@Service
public class DonationService extends AbstractService<Donation, Integer> {
	
	private IDonationRepo repository;
	
	@Autowired
	public DonationService(IDonationRepo repo) { 
		super(repo); 
		this.repository = repo;
	}
	
	@Transactional
	public Page<InfoDonationDTO> getDonationsFromUser(Pageable pageable ,int id) {
		Page<Donation> page = this.repository.getDonationsFromUser(pageable, id);
		
		List<InfoDonationDTO> donationsFromUser = page.get().map(donation -> new InfoDonationDTO(donation.getPoints(),
			donation.getProjectName(), donation.getAmount(), donation.getDate().toString())).collect(Collectors.toList());
		
		return new PageImpl<InfoDonationDTO>(donationsFromUser, pageable, page.getTotalElements());
	}
}