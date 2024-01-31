package fr.uga.miage.m1.controller.create;

import lombok.Getter;

import java.util.Date;

@Getter
public class UtilisateurCreate {

    public UtilisateurCreate(
            String email,
            String nom,
            String prenom,
            String motDePasse,
            Date dateNaissance,
            String telephone
    ) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
    }


    private final String email;

    private final String nom;

    private final String prenom;

    private final String motDePasse;

    private final Date dateNaissance;

    private final String telephone;


    @Override
    public String toString() {
        return "UtilisateurDTO{" +
                "email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

