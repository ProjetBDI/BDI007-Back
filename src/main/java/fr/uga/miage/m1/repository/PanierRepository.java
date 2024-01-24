package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    
}
