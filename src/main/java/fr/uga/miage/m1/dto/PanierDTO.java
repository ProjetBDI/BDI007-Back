package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierDTO {

    private Long idPanier;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO proprietaire;
    
    private List<PanierEtapeDTO> panierEtapes;
    
}
