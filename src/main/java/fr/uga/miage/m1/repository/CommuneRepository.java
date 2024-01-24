package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long>{
    
    // READ
    Commune findByID(long id);
    Commune findByCodeINSEE(String codeINSEE);
    List<Commune> findByNomCommune(String nomCommune);
    List<Commune> findByCodePostal(String codePostal);
}
