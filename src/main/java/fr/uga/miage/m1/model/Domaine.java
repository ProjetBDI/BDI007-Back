package fr.uga.miage.m1.model;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "domaine",
        uniqueConstraints = @UniqueConstraint(name = "UNQ_NOMDOMAINE_NOMSOUSDOMAINE", columnNames = {"nom_domaine", "nom_sous_domaine"})
)

public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_domaine", nullable = false)
    private int id_domaine;

    @Column(name = "nom_domaine", nullable = false)
    private String nomDomaine;


    @Column(name = "nom_sous_domaine", nullable = true)
    private String sousDomaines;

    @OneToMany(mappedBy = "id_domaine")
    private List<Festival> festivals;
}
