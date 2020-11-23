package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.InfoDonationDTO;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.DonationService;

@RestController
@RequestMapping("/donations")
public class DonationWebService extends AbstractWebService<Donation> {
	@Autowired
	private DonationService donationService;
	
	@GetMapping(value="/getDonationsFromUser/{id}")
	public Page<InfoDonationDTO> getDonationsFromUser(
			@PathVariable("id") int id,
			@PageableDefault(size = 5) Pageable pageable,
			@RequestParam(defaultValue = "0") int page) {
		return this.donationService.getDonationsFromUser(pageable, id);
	}
}