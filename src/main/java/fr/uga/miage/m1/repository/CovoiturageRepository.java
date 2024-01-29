package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Covoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CovoiturageRepository extends JpaRepository<Covoiturage, Long> {

    Collection<Covoiturage> findByNbPlaceDispo(int nbPlaceDispo);

    Collection<Covoiturage> findByNbPlace(int nbPlace);
}