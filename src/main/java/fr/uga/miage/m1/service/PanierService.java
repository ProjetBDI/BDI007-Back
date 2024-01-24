package fr.uga.miage.m1.service;

import org.springframework.stereotype.Service;

import fr.uga.miage.m1.repository.PanierRepository;

@Service
public class PanierService {
    
    // SAVE
    public Panier save(Panier panier) {
        return panierRepository.save(panier);
    }

    // GET
    public List<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }
}
