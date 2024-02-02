package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.FestivalStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "FestivalDTO", description = "FestivalDTO description")
public class FestivalDTO {

    private long idFestival;

    private String nom;

    private String dateDebut;

    private String dateFin;

    private String siteWeb;

    private String lieuPrincipal;

    private int nbPassTotal;

    private int nbPassDispo;

    private int nbPassIndispo;

    private int nbPassVendus;


    private float tarifPass;

    private FestivalStatus status;

    private CommuneDTO idCommune;

    private DomaineDTO idDomaine;
}
