package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    
    // CREATE
    void create(UtilisateurDTO utilisateur);

    // READ
    UtilisateurDTO findByEmail(String email);
    UtilisateurDTO findByPaniers(Long idPanier);

    // UPDATE
    void update(UtilisateurDTO utilisateur);

    // DELETE
    void delete(UtilisateurDTO utilisateur);
    
}

