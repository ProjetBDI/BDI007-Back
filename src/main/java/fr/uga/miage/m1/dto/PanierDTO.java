package fr.uga.miage.m1.dto;

import java.util.Collection;
import java.util.Date;

import fr.uga.miage.m1.enums.PanierStatus;

public class PanierDTO {

    private Long idPanier;
    private PanierStatus status;
    private Date datePaiement;
    private String nomsFestivaliers;
    private UtilisateurDTO proprietaire;
    private List<PanierEtapeDTO> panierEtapes;
    
}
