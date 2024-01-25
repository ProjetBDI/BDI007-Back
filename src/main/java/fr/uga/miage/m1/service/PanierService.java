package fr.uga.miage.m1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.repository.PanierRepository;

@Service
public class PanierService {

    private final PanierRepository panierRepository;

    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }
    
    // SAVE
    public Panier save(Panier panier) {
        return panierRepository.save(panier);
    }

    // GET
    public Iterable<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    public Panier getById(Long id) {
        return panierRepository.findById(id).get();
    }

    // DELETE
    public void deleteById(Long id) {
        panierRepository.deleteById(id);
    }

    public void delete(Panier panier) {
        panierRepository.delete(panier);
    }
}
