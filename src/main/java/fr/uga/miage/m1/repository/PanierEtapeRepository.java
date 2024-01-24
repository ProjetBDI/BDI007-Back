package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.PanierEtape;

public interface PanierEtapeRepository extends JpaRepository<PanierEtape, Long>{

    // READ
    PanierEtape findByIdPanier(long idPanier);
    PanierEtape findByIdEtape(long idEtape);
    PanierEtape findByIds(long idPanier, long idEtape);
}
