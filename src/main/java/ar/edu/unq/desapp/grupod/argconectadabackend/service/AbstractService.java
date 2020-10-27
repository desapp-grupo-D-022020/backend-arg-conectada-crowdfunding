package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class AbstractService<T, ID> implements IService<T, ID> {
	
	protected JpaRepository<T, ID> repo;
	
	public AbstractService(JpaRepository<T, ID> repo) {
		this.repo = repo;
	}
	
	@Transactional
	@Override
	public List<T> getAll() { return repo.findAll(); }
	
	@Transactional
	@Override
	public T getById(ID id) { return repo.getOne(id); }

	@Transactional
	@Override
	public void save(T t) { repo.save(t); }

	@Transactional
	@Override
	public void update(T t) { repo.save(t); }
	
	@Transactional
	@Override
	public void delete(ID id) { repo.deleteById(id); } 
}