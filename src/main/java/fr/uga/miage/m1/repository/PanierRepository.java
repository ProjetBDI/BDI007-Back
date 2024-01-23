package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
    
    // CREATE
    void create(PanierDTO panier);

    // READ
    PanierDTO findByIDPanier(Long idPanier);
    PanierDTO findByProprietaire(String email); 

    // UPDATE
    void update(PanierDTO panier);

    // DELETE
    void delete(PanierDTO panier);
}
