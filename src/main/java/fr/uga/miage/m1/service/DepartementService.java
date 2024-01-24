package fr.uga.miage.m1.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.repository.DepartementRepository;

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
    public Optional<Departement> getById(Long id) {
        return departementRepository.findById(id);
    }

    public Departement getByNom(String nom) {
        return departementRepository.findByNom(nom);
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
}
