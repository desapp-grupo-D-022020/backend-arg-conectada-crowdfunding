package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupod.argconectadabackend.enums.RolName;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Rol;
import ar.edu.unq.desapp.grupod.argconectadabackend.repository.RolRepo;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepo rolRepo;

    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepo.findByRolName(rolName);
    }
    
}