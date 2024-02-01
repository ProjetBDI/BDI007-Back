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
        long idPanierEtape,
        long nbPlaceOccuppe,
        EtapeDTO idEtape,
        PanierDTO idPanier
    ) {
        this.idPanierEtape = idPanierEtape;
        this.nbPlaceOccuppe = nbPlaceOccuppe;
        this.idEtape = idEtape;
        this.idPanier = idPanier;
    }

    private long idPanierEtape;

    private long nbPlaceOccuppe;
    
    private EtapeDTO idEtape;

    private PanierDTO idPanier;
}
