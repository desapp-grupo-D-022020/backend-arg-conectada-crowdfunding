package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupod.argconectadabackend.repository.IRepo;

@Service
public abstract class AbstractService<T, ID> implements IService<T, ID> {
	
	protected IRepo<T, ID> repo;
	
	public AbstractService(IRepo<T, ID> repo) {
		this.repo = repo;
	}
	@Transactional
	@Override
	public List<T> getAll() { return (List<T>) repo.findAll(); }
	
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