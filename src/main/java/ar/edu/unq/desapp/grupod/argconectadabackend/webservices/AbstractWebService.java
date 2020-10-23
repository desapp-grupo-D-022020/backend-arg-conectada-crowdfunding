package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.service.IService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public abstract class AbstractWebService<T> {
	
	@Autowired
	protected IService<T, Integer> service;
	
	@GetMapping(value= "/all")
	public List<T> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value="/get/{id}")
	public T getOne(@PathVariable("id") Integer id) {
		return service.getById(id);
	}
	
	@PostMapping(value="/save")
	public void insert(@RequestBody T t) {
		service.save(t);
	}
	
	@PutMapping(value="/update")
	public void update(@RequestBody T t) {
		service.update(t);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}