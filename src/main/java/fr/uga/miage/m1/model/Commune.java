package fr.uga.miage.m1.model;

import jakarta.persistence.*;

import java.util.List;

import lombok.Data;

@Entity
@Data
@Table(
        name = "commune",
        uniqueConstraints = @UniqueConstraint(name = "UNQ_COMMUNE_CODEINSEE", columnNames = {"code_insee"})
)
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_commune", nullable = false)
    private Long id_commune;

    @Column(name = "code_insee", nullable = false)
    private String codeINSEE;

    @Column(name = "nom_commune", nullable = false)
    private String nomCommune;

    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @OneToMany(mappedBy = "id_commune") // Utilisation de "mappedBy" pour indiquer le champ dans l'entité liée
    private List<Festival> festivals;

    @OneToMany(mappedBy = "id_commune") // Utilisation de "mappedBy" pour indiquer le champ dans l'entité liée
    private List<Lieu> lieux;

    @ManyToOne
    @JoinColumn(name = "id_departement", referencedColumnName = "id_departement", nullable = false)
    // correction de referencedColumnName
    private Departement id_departement;
}