package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {
    Collection<Commune> findByNomCommune(String nomCommune);

    Collection<Commune> findByCodePostal(String codePostal);

}
