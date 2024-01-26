package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "UtilisateurDTO", description = "UtilisateurDTO description")
public class UtilisateurDTO {

    public UtilisateurDTO(
<<<<<<< HEAD
        long idUtilisateur,
        String email,
        String nom,
        String prenom,
        String motDePasse,
        Date dateNaissance,
        String telephone
    ) {
=======

            long idUtilisateur,
            String email,
            String nom,
            String prenom,
            String motDePasse,
            Date dateNaissance,
            String telephone,
            List<PanierDTO> paniers,
            List<CovoiturageDTO> covoiturages
    ) {

>>>>>>> 53152617b98430533fbcf796d9a2f290100700d1
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
    }

    private long idUtilisateur;

    private String email;

    private String nom;

    private String prenom;

    private String motDePasse;

    private Date dateNaissance;

    private String telephone;


    @Override
    public String toString() {
        return "UtilisateurDTO{" +
                "idUtilisateur=" + idUtilisateur +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
