package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierDTO {

    private long id_panier;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO id_proprietaire;
    
    private List<PanierEtapeDTO> panierEtapes;
    
}