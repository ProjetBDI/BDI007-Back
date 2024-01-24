package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.PanierEtape;

public interface PanierEtapeRepository extends JpaRepository<PanierEtape, Long>{
    
    // CREATE
    void create(PanierEtape panierEtape);

    // READ
    PanierEtape findByIDPanier(long idPanier);
    PanierEtape findByIdEtape(long idEtape);
    PanierEtape findByIDs(long idPanier, long idEtape);

    // UPDATE
    void update(PanierEtape panierEtape);

    // DELETE
    void delete(PanierEtape panierEtape);
}
