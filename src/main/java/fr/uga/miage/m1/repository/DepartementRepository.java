package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, String> {
    
    // READ
    DepartementDTO findByID(String idDepartement);
    
}
