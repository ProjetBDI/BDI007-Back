package fr.uga.miage.m1.dto;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "PanierDTO", description = "PanierDTO description")
public class PanierDTO {

    public PanierDTO(
        long idPanier,
        Date datePaiement,
        String nomsFestivaliers,
        UtilisateurDTO idProprietaire,
        List<PanierEtapeDTO> panierEtapes
    ) {
        this.idPanier = idPanier;
        this.datePaiement = datePaiement;
        this.nomsFestivaliers = nomsFestivaliers;
        this.idProprietaire = idProprietaire;
        this.panierEtapes = panierEtapes;
    }

    private long idPanier;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO idProprietaire;
    
    private List<PanierEtapeDTO> panierEtapes;
    
}
