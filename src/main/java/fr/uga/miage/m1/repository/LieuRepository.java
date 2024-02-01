package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Long> {
}
