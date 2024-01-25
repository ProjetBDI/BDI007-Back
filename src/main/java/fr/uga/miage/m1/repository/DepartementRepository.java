package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long> {
    
}
