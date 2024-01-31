package fr.uga.miage.m1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "commune")
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_commune", nullable = false)
    private Long idCommune;

    @Column(name = "code_insee", nullable = false)
    private String codeINSEE;

    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "nom_commune", nullable = false)
    private String nomCommune;

    @ManyToOne
    @JoinColumn(name = "id_departement", referencedColumnName = "id_departement", nullable = false) // correction de referencedColumnName
    private Departement idDepartement;

    @OneToMany(mappedBy = "idCommune") // Utilisation de "mappedBy" pour indiquer le champ dans l'entité liée
    private List<Festival> festivals;

    @OneToMany(mappedBy = "idCommune") // Utilisation de "mappedBy" pour indiquer le champ dans l'entité liée
    private List<Lieu> lieux;


}