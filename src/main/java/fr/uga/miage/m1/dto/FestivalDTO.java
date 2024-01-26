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

    public FestivalDTO(long idFestival, String nom, String dateDebut, String dateFin, String siteWeb, String lieuPrincipal, int nbPassTotal, int nbPassDispo, int nbPassIndispo, float tarifPass, FestivalStatus status, CommuneDTO idCommune, DomaineDTO idDomaine) {
        this.idFestival = idFestival;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.siteWeb = siteWeb;
        this.lieuPrincipal = lieuPrincipal;
        this.nbPassTotal = nbPassTotal;
        this.nbPassDispo = nbPassDispo;
        this.nbPassIndispo = nbPassIndispo;
        this.tarifPass = tarifPass;
        this.status = status;
        this.idCommune = idCommune;
        this.idDomaine = idDomaine;
    }
    
    private long idFestival;

    private String nom;

    private String dateDebut;

    private String dateFin;

    private String siteWeb;

    private String lieuPrincipal;

    private int nbPassTotal;

    private int nbPassDispo;

    private int nbPassIndispo;

    private float tarifPass;

    private FestivalStatus status;

    private CommuneDTO idCommune;

    private DomaineDTO idDomaine;
}
