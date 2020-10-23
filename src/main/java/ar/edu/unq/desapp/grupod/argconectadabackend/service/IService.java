package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T, ID> {
	
	List<T> getAll();
	
	T getById(ID id);

	void save(T obj);
	
	void update(T obj);
	
	void delete(ID id);
	
}