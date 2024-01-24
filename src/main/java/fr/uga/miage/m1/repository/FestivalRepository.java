package fr.uga.miage.m1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Festival;

public interface FestivalRepository extends JpaRepository<Festival, Long>{
    
    // CREATE
    void create(Festival festival);

    // READ
    Festival findByID(long id);
    List<Festival> findByNom(String nomFestival);

    // UPDATE
    void update(Festival festival);

    // DELETE
    void delete(Festival festival);
}
