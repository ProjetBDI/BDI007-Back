package fr.uga.miage.m1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nom;

    @OneToMany(mappedBy = "domaine", cascade = CascadeType.ALL)
    private List<Festival> festivals;
}
