package fr.uga.miage.m1.service;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Lieu;
import fr.uga.miage.m1.repository.LieuRepository;

@Service
public class LieuService {
    
    private final LieuRepository lieuRepository;

    public LieuService(LieuRepository lieuRepository) {
        this.lieuRepository = lieuRepository;
    }

    // SAVE
    public Lieu save(Lieu lieu) {
        return lieuRepository.save(lieu);
    }

    // GET
    public Lieu getById(Long id) {
        return lieuRepository.findById(id).get();
    }

    public Lieu getByTypeLieu(String typeLieu) {
        return lieuRepository.findByTypeLieu(typeLieu);
    }

    // DELETE
    public void deleteById(Long id) {
        lieuRepository.deleteById(id);
    }

    public void delete(Lieu lieu) {
        lieuRepository.delete(lieu);
    }
}
