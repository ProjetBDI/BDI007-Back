package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Lieu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuRepository extends CrudRepository<Lieu, Long> {
}
