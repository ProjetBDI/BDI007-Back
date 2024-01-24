package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;

@Service
public class FestivalService {
    
    private final FestivalRepository festivalRepository;

    public FestivalService(FestivalRepository festivalRepository) {
        this.festivalRepository = festivalRepository;
    }

    // SAVE
    public void save(Festival festival) {
        festivalRepository.save(festival);
    }

    // GET
    public Festival getById(Long id) {
        return festivalRepository.findById(id).get();
    }

    public List<Festival> getByNom(String nom) {
        return festivalRepository.findByNom(nom);
    }

    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }

    // DELETE
    public void deleteById(Long id) {
        festivalRepository.deleteById(id);
    }

    public void delete(Festival festival) {
        festivalRepository.delete(festival);
    }
}
