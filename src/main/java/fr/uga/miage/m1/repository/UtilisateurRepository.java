package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


    // READ
    Utilisateur findByEmail(String email);
    Utilisateur findByIDPanier(long idPanier);
    
}

