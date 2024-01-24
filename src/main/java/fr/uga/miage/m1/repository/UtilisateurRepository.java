package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    // READ
    Utilisateur findByID(long id);
    Utilisateur findByEmail(String email);
    Utilisateur findByPanier(long idPanier);
    
}

