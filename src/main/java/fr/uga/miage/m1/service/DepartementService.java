package fr.uga.miage.m1.service;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.DepartementRepository;

import java.util.List;

@Service
public class DepartementService {
    
    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    // SAVE
    public void save(Departement departement) {
        departementRepository.save(departement);
    }

    // GET
    public Departement getById(Long id) {
        return departementRepository.findById(id).get();
    }

    // DELETE
    public void deleteById(Long id) {
        departementRepository.deleteById(id);
    }

    public void delete(Departement departement) {
        departementRepository.delete(departement);
    }

    //get All
    public Iterable<Departement> getAllDepartements(){return departementRepository.findAll();}
}
