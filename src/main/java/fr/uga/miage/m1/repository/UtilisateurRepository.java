package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
    // CREATE
    void create(Utilisateur utilisateur);

    // READ
    Utilisateur findByID(long id);
    Utilisateur findByEmail(String email);
    Utilisateur findByPaniers(long idPanier);

    // UPDATE
    void update(Utilisateur utilisateur);

    // DELETE
    void delete(Utilisateur utilisateur);
    
}

