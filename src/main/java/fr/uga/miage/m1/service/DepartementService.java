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

    public Departement getByNom(String nomDepartement) {
        return departementRepository.findByNomDepartement(nomDepartement);
    }

    public Departement getByNumDepartement(String nuDepartement) {
        return departementRepository.findByNumDepartement(nuDepartement);
    }

    // DELETE
    public void deleteById(Long id) {
        departementRepository.deleteById(id);
    }

    public void delete(Departement departement) {
        departementRepository.delete(departement);
    }

    //get All
    public List<Departement> getAllDepartements(){return departementRepository.findAll();}
}
