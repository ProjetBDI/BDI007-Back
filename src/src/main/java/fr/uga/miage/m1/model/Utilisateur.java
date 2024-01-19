package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "Utilisateur")
public class Utilisateur {

    @Id
    @Column(name="email", nullable = false)
    private String email;

    @Column(name="nom", nullable = false)
    private String nom;

    @Column(name="prenom", nullable = false)
    private String prenom;

    @Column(name="motDePasse", nullable = false)
    private String motDePasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateNaissance", nullable = false)
    private Date dateNaissance;

    @OneToMany(mappedBy = "proprietaire")
    private List<Panier> paniers;


    @OneToMany(mappedBy = "conducteur")
    private List<Covoiturage> covoiturages;

}

