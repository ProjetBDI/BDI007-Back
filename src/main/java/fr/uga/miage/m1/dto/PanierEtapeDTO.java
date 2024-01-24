package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PanierEtapeDTO {

    private long id_panier_etape;

    private long nbPlaceOccuppe;
    
    private EtapeDTO id_etape;

    private PanierDTO id_panier;
}
