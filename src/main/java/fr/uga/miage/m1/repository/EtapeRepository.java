package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.EtapeDTO;

public interface EtapeRepository extends JpaRepository<EtapeRepository, Long>{
    
    // CREATE
    void create(EtapeDTO etape);

    // READ
    EtapeDTO findByID(Long idLieu, Long idCovoiturage);
    EtapeDTO findByPrix(float prixEtape);

    // UPDATE
    void update(EtapeDTO etape);

    // DELETE
    void delete(EtapeDTO etape);
}
