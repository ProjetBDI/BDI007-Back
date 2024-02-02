package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Long> {

}
