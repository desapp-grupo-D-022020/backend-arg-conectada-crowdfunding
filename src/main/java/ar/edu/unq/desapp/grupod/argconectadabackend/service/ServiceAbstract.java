package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ServiceAbstract<T, ID> implements IService<T, ID> {
	
	@Autowired
	private JpaRepository<T, ID> repo;
	
	public ServiceAbstract(JpaRepository<T, ID> repo) {
		this.repo = repo;
	}

	@Override
	public List<T> getAll() { return (List<T>) repo.findAll(); }
	
	@Override
	public T getById(ID id) { return repo.getOne(id); }

	@Override
	public void save(T t) { repo.save(t); }

	@Override
	public void update(T t) { repo.save(t); }
	
	@Override
	public void delete(ID id) { repo.deleteById(id); } 
}