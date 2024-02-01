package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.PanierEtape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierEtapeRepository extends JpaRepository<PanierEtape, Long> {
}
