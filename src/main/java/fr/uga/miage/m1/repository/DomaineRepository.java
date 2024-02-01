package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long> {
}
