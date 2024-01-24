package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    
    // CREATE
    void create(Panier panier);

    // READ
    Panier findByProprietaire(String email); 

    // UPDATE
    void update(Panier panier);

    // DELETE
    void delete(Panier panier);
}
