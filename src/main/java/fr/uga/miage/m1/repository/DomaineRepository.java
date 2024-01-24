package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Domaine;

public interface DomaineRepository extends JpaRepository<Domaine, Long>{
    
    // READ
    Domaine findByNomDomaine(String nomDomaine);
    List<Domaine> findBySousDomaines(String sousDomaine);
}
