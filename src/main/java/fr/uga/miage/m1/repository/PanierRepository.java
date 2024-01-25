package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierRepository extends CrudRepository<Panier, Long> {
    
}
