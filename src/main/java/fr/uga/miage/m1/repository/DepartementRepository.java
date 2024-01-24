package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    
    // READ
    Departement findByNomDepartement(String nomDepartement);
    Departement findByNumDepartement(String numDepartement);
    List<Departement> findByNomRegion(String nomRegion);
    
}