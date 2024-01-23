package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.model.Covoiturage;

public interface CovoiturageRepository extends JpaRepository<Covoiturage, Long>{
    
    // CREATE
    void create(CovoiturageDTO covoiturage);

    // READ
    CovoiturageDTO findById(long id);

    // UPDATE
    void update(CovoiturageDTO covoiturage);

    // DELETE
    void delete(CovoiturageDTO covoiturage);
}
