package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UtilisateurDTO {

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

