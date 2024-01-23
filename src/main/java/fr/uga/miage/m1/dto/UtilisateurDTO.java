package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

public class UtilisateurDTO {
    
    private String email;

    private String nom;
    
    private String prenom;
    
    private String motDePasse;

    private Date dateNaissance;

    private List<PanierDTO> paniers;

    private List<CovoiturageDTO> covoiturages;

}

