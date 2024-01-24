package fr.uga.miage.m1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.uga.miage.m1.model.Covoiturage;

public interface CovoiturageRepository extends JpaRepository<Covoiturage, Long>{
}
