package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierEtapeDTO {

    private long idPanierEtape;
    
    private long etapeLieu;
    
    private long etapeCovoiturage;
    
    private long nbPlaceOccuppe;
    
    private PanierDTO panier;
    
    private EtapeDTO etape;
}
