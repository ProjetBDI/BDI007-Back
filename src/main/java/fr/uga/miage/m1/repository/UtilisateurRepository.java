package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    
    List<Utilisateur> findByNom(String nom);
    
}

