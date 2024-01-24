package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Etape;

public interface EtapeRepository extends JpaRepository<Etape, Long>{

    // READ
    Etape findByIds(long idLieu, long idCovoiturage);
    Etape findByPrix(float prixEtape);
}
