package fr.uga.miage.m1.dto;

import java.util.Date;
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
        UtilisateurDTO idProprietaire
    ) {
        this.idPanier = idPanier;
        this.datePaiement = datePaiement;
        this.nomsFestivaliers = nomsFestivaliers;
        this.idProprietaire = idProprietaire;
    }

    private long idPanier;
    
    private Date datePaiement;
    
    private String nomsFestivaliers;
    
    private UtilisateurDTO idProprietaire;
    
}
