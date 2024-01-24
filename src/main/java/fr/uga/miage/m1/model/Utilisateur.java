package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utilisateur", nullable = false)
    private Long id_utilisateur;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mot_de_passe", nullable = true)
    private String motDePasse;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_naissance", nullable = false)
    private Date dateNaissance;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "id_proprietaire")
    private List<Panier> paniers;


    @OneToMany(mappedBy = "id_conducteur")
    private List<Covoiturage> covoiturages;

}

