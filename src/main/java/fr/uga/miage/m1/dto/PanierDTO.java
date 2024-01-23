package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.enums.PanierStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierDTO {

    private Long idPanier;
    
    private PanierStatus status;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO proprietaire;
    
    private List<PanierEtapeDTO> panierEtapes;
    
}
