package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.repository.UtilisateurRepository;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Optional<Utilisateur> getUserByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    // Ajouter des méthodes spécifiques de service ici si nécessaire
}
