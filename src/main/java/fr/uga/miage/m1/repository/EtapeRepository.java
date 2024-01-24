package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Etape;

public interface EtapeRepository extends JpaRepository<Etape, Long>{
    
    // CREATE
    void create(Etape etape);

    // READ
    Etape findByID(long idLieu, long idCovoiturage);
    Etape findByPrix(float prixEtape);

    // UPDATE
    void update(Etape etape);

    // DELETE
    void delete(Etape etape);
}
