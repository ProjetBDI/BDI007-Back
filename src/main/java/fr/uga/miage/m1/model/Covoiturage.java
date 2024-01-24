package fr.uga.miage.m1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Data
@Table (name = "covoiturage")
public class Covoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_covoiturage", nullable = false)
    private long id_covoiturage;

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

    @OneToMany(mappedBy = "id_covoiturage")
    private List<Etape> etapes;
    
    @ManyToOne
    @JoinColumn(name = "id_festival", referencedColumnName = "id_festival")
    private Festival id_festival;

    @ManyToOne
    @JoinColumn(name = "id_conducteur", referencedColumnName = "id_utilisateur", insertable = true, updatable = true)
    private Utilisateur id_conducteur;

}

