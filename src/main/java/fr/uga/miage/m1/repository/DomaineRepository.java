package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Domaine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends CrudRepository<Domaine, Long> {
}
