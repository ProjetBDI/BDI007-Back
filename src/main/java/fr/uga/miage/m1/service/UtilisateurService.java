package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Utilisateur;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.repository.UtilisateurRepository;

import java.util.Collection;
import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // SAVE
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // GET
    public Iterable<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur getById(Long id) {
        return utilisateurRepository.findById(id).get();
    }



    // DELETE
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }
}
