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
        String telephone,
        List<PanierDTO> paniers,
        List<CovoiturageDTO> covoiturages
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
            List<CovoiturageDTO> covoiturages) {
>>>>>>> 722b366d66cef9127702ced153041031b46cdebf
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.paniers = paniers;
        this.covoiturages = covoiturages;
    }

    private long idUtilisateur;

    private String email;

    private String nom;

    private String prenom;

    private String motDePasse;

    private Date dateNaissance;

    private String telephone;

    private List<PanierDTO> paniers;

    private List<CovoiturageDTO> covoiturages;

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
                ", paniers=" + paniers +
                ", covoiturages=" + covoiturages +
                '}';
    }
}
