package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.DonationService;

@RestController
@RequestMapping("/donations")
public class DonationWebService extends AbstractWebService<Donation> {
	@Autowired
	private DonationService donationService;
	
	@GetMapping(value="/getDonationsFromUser/{id}")
	public List<Donation> getCost(@PathVariable("id") int id) {
		return this.donationService.getDonationsFromUser(id);
	}
	
}