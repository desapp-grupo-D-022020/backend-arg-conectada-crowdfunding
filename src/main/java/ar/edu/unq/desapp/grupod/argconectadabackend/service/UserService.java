package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IUserRepo;
import ar.edu.unq.desapp.grupod.argconectadabackend.utils.PointsManager;

@Service
public class UserService extends AbstractService<User, Integer> {
	
	private PointsManager pointsManager;
	
	@Autowired
	public UserService(IUserRepo repo, PointsManager pointsManager) { 
		super(repo); 
		this.pointsManager = pointsManager;
	}
	
	public void assignPoints(User donor, Project project, double donationAmount) {
		String nameOfProject = project.getName();
		List<Double> pointsToAssign = pointsManager.calculatePoints(donor, project, donationAmount);
		donor.addPointsToRegister(nameOfProject, pointsManager.sumPoints(pointsToAssign));
	}
	
}