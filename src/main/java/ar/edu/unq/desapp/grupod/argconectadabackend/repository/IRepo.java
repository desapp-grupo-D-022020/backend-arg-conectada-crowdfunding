package ar.edu.unq.desapp.grupod.argconectadabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepo<T, ID> extends JpaRepository<T, ID>{ }
