package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.model.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long>{
    
    // READ
    CommuneDTO findByID(String codeINSEE);
    List<CommuneDTO> findByNomCommune(String nomCommune);
    List<CommuneDTO> findByCodePostal(String codePostal);
}
