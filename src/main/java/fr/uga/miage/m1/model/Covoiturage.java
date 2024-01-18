package fr.uga.miage.m1.model;

import jakarta.persistence.CascadeType;
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
    private long nbPlace;

    @Column(name = "nbPlaceDispo")
    private long nbPlaceDispo;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "couleur")
    private String couleur;

    @Temporal(TemporalType.DATE)
    @Column(name = "heureDepart")
    private Date heureDepart;

    @Column(name = "emailConducteur", nullable = false)
    private String emailConducteur;

    @OneToMany(mappedBy = "etape", cascade = CascadeType.ALL)
    private List<Etape> etapes;
    
    @ManyToOne
    @JoinColumn(name = "idFestival")
    private Festival festival;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
}

