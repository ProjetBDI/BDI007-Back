package fr.uga.miage.m1.service;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.repository.CovoiturageRepository;

import java.util.List;

@Service
public class CovoiturageService {
    
    private final CovoiturageRepository covoiturageRepository;
    
    public CovoiturageService(CovoiturageRepository covoiturageRepository) {
        this.covoiturageRepository = covoiturageRepository;
    }

    // SAVE
    public void save(Covoiturage covoiturage) {
        covoiturageRepository.save(covoiturage);
    }

    // GET
    public Covoiturage getById(Long id) {
        return covoiturageRepository.findById(id).get();
    }

    // DELETE
    public void deleteById(Long id) {
        covoiturageRepository.deleteById(id);
    }

    public void delete(Covoiturage covoiturage) {
        covoiturageRepository.delete(covoiturage);
    }

    public Iterable<Covoiturage> getAllCovoiturages() {return covoiturageRepository.findAll();}
}
