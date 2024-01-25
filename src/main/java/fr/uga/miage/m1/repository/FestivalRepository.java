package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Festival;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalRepository extends CrudRepository<Festival, Long> {
}
