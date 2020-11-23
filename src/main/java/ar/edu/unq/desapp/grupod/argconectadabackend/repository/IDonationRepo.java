package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;

@Repository
public interface IDonationRepo extends JpaRepository<Donation, Integer> {
	
    @Query(value = "SELECT * FROM DONATION d WHERE d.DONOR_ID = :id ", nativeQuery = true)
    public Page<Donation> getDonationsFromUser(Pageable page, @Param("id") Integer id);
}