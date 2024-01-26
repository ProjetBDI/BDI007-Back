package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utilisateur", nullable = false)
    private Long idUtilisateur;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mot_de_passe", nullable = true)
    private String motDePasse;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance", nullable = false)
    private Date dateNaissance;

    @Column(name = "telephone")
    private String telephone;





}

