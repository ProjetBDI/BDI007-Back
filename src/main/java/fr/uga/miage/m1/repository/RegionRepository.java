package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.RegionDTO;
import fr.uga.miage.m1.model.Region;

public interface RegionRepository extends JpaRepository<Region, String> {

    // READ
    RegionDTO findByNomRegion(String nomRegion);
    RegionDTO findByDepartements(String nomDepartement); 
}
