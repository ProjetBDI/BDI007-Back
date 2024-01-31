package fr.uga.miage.m1.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table (name = "covoiturage")
public class Covoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_covoiturage", nullable = false)
    private Long idCovoiturage;

    @Column(name = "nb_place")
    private int nbPlace;

    @Column(name = "nb_place_dispo")
    private int nbPlaceDispo;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "couleur")
    private String couleur;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_depart")
    private Date dateDepart;

    @OneToMany(mappedBy = "idCovoiturage")
    private List<Etape> etapes;
    
    @ManyToOne
    @JoinColumn(name = "id_festival", referencedColumnName = "id_festival")
    private Festival idFestival;

    @ManyToOne
    @JoinColumn(name = "id_conducteur", referencedColumnName = "id_utilisateur", insertable = true, updatable = true)
    private Utilisateur idConducteur;

}