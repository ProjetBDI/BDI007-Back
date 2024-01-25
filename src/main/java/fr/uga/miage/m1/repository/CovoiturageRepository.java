package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Covoiturage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CovoiturageRepository extends CrudRepository<Covoiturage, Long> {
}
