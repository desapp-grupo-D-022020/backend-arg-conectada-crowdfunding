package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;

@Repository
public interface IProjectRepo extends JpaRepository<Project, Integer> {
	
    @Query(value = "SELECT * FROM PROJECT p WHERE p.IS_OPEN AND MONTH(p.END_DATE) >= :month "
    		+ "AND YEAR(p.END_DATE) >= :year", nativeQuery = true)
    public Page<Project> getOpenProjects(Pageable page, @Param("month") Integer month, @Param("year") Integer year);

    @Query(value = "SELECT * FROM PROJECT p WHERE p.IS_OPEN AND MONTH(p.END_DATE) = :month "
    		+ "AND YEAR(p.END_DATE) = :year AND DAY(p.END_DATE) >= :day", nativeQuery = true)
    public Page<Project> getNearlyClosedProjects(Pageable page, @Param("month") Integer month, 
    		@Param("year") Integer year, @Param("day") Integer day);
}