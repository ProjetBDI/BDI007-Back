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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Data
public class Covoiturage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCovoiturage;

    @Column(name = "nbPlace")
    private int nbPlace;

    @Column(name = "nbPlaceDispo")
    private int nbPlaceDispo;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "couleur")
    private String couleur;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDepart")
    private Date dateDepart;

    @Column(name = "emailConducteur", nullable = false)
    private String emailConducteur;

    @OneToMany
    @JoinColumn(name = "idCovoiturage", referencedColumnName = "idCovoiturage", table = "Etape", insertable = true, updatable = true)
    private List<Etape> etapes;
    
    @ManyToOne
    @JoinColumn(name = "festival", referencedColumnName = "idFestival", table = "Festival", insertable = true, updatable = true)
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "emailConducteur", referencedColumnName = "email", table = "Utilisateur", insertable = true, updatable = true)
    private Utilisateur conducteur;
}

