package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.LieuDTO;

public interface LieuRepository extends JpaRepository<LieuRepository, String>{
    
    // READ
    LieuDTO findByID(Long idLieu);
}
