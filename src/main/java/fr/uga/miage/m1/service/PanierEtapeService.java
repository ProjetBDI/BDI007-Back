package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.repository.PanierEtapeRepository;

@Service
public class PanierEtapeService {
    
    private final PanierEtapeRepository panierEtapeRepository;

    public PanierEtapeService(PanierEtapeRepository panierEtapeRepository) {
        this.panierEtapeRepository = panierEtapeRepository;
    }

    // SAVE
    public void save(PanierEtape panierEtape) {
        panierEtapeRepository.save(panierEtape);
    }

    // GET
    public PanierEtape getById(Long id) {
        return panierEtapeRepository.findById(id).get();
    }

    public Iterable<PanierEtape> getAllPaniers() {
        return panierEtapeRepository.findAll();
    }

    // DELETE
    public void deleteById(Long id) {
        panierEtapeRepository.deleteById(id);
    }

    public void delete(PanierEtape panierEtape) {
        panierEtapeRepository.delete(panierEtape);
    }
}
