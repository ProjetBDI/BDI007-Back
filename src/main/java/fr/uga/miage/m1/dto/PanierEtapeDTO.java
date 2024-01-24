package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "PanierEtapeDTO", description = "PanierEtapeDTO description")
public class PanierEtapeDTO {

    public PanierEtapeDTO(
        long id_panier_etape,
        long nbPlaceOccuppe,
        EtapeDTO id_etape,
        PanierDTO id_panier
    ) {
        this.id_panier_etape = id_panier_etape;
        this.nbPlaceOccuppe = nbPlaceOccuppe;
        this.id_etape = id_etape;
        this.id_panier = id_panier;
    }

    private long id_panier_etape;

    private long nbPlaceOccuppe;
    
    private EtapeDTO id_etape;

    private PanierDTO id_panier;
}
