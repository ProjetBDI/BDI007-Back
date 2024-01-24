package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class UtilisateurDTO {

    public UtilisateurDTO(
        long id_utilisateur,
        String email,
        String nom,
        String prenom,
        String motDePasse,
        Date dateNaissance,
        String telephone,
        List<PanierDTO> paniers,
        List<CovoiturageDTO> covoiturages
    ) {
        this.id_utilisateur = id_utilisateur;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.paniers = paniers;
        this.covoiturages = covoiturages;
    }

    private long id_utilisateur;
    
    private String email;

    private String nom;
    
    private String prenom;
    
    private String motDePasse;

    private Date dateNaissance;

    private String telephone;

    private List<PanierDTO> paniers;

    private List<CovoiturageDTO> covoiturages;

}

