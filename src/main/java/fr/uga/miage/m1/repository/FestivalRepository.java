package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.model.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Long>{
    
    // CREATE
    void create(FestivalDTO festival);

    // READ
    FestivalDTO findById(long id);
    List<FestivalDTO> findByNom();

    // UPDATE
    void update(FestivalDTO festival);

    // DELETE
    void delete(FestivalDTO festival);
}
