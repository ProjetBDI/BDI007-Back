package fr.uga.miage.m1.service;

import fr.uga.miage.m1.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // SAVE
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // GET
    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Utilisateur getByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur getByPanier(long idPanier) {
        return utilisateurRepository.findByPanier(idPanier);
    }

    // DELETE
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
