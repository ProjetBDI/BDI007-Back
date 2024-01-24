package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, Long>{
    
    // READ
    Lieu findByTypeLieu(String typeLieu);
}
