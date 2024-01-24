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
        long id_panier,
        Date datePaiement,
        String nomsFestivaliers,
        UtilisateurDTO id_proprietaire,
        List<PanierEtapeDTO> panierEtapes
    ) {
        this.id_panier = id_panier;
        this.datePaiement = datePaiement;
        this.nomsFestivaliers = nomsFestivaliers;
        this.id_proprietaire = id_proprietaire;
        this.panierEtapes = panierEtapes;
    }

    private long id_panier;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO id_proprietaire;
    
    private List<PanierEtapeDTO> panierEtapes;
    
}
