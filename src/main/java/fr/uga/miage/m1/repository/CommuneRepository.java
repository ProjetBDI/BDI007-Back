package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Commune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends CrudRepository<Commune, Long> {
    
}
