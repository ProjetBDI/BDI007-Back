package fr.uga.miage.m1.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "sous_domaine")
public class SousDomaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nom_sous_domaine", nullable = false)
    private String nomSousDomaine;

    @ManyToOne()
    @JoinColumn(name = "nom_domaine", referencedColumnName = "nom_domaine")
    private Domaine nomDomaine;

    @OneToMany(mappedBy = "sousDomaine")
    private List<Festival> festivals;
}
