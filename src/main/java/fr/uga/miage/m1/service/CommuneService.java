package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.repository.CommuneRepository;

@Service
public class CommuneService {
    
    private final CommuneRepository communeRepository;

    public CommuneService(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    // SAVE
    public void save(fr.uga.miage.m1.model.Commune commune) {
        communeRepository.save(commune);
    }

    // GET
    public Commune getById(Long id) {
        return communeRepository.findById(id).get();
    }

    public Commune getByNom(String nom) {
        return communeRepository.findByNomCommune(nom);
    }

    public List<Commune> getByCodePostal(String codePostal) {
        return communeRepository.findByCodePostal(codePostal);
    }

    public List<Commune> getAllCommunes() {
        return communeRepository.findAll();
    }

    // DELETE
    public void deleteById(Long id) {
        communeRepository.deleteById(id);
    }

    public void delete(Commune commune) {
        communeRepository.delete(commune);
    }
}
