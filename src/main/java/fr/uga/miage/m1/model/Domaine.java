package fr.uga.miage.m1.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "domaine")
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nom_domaine", nullable = false)
    private String nomDomaine;

    @OneToMany(mappedBy = "nomSousDomaine")
    private List<SousDomaine> sousDomaines;
}
