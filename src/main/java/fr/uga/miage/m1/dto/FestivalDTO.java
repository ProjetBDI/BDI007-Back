package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.FestivalStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "FestivalDTO", description = "FestivalDTO description")
public class FestivalDTO {

    public FestivalDTO(long id_festival, String nom, String dateDebut, String dateFin, String siteWeb, String lieuPrincipal, int nbPassTotal, int nbPassDispo, int nbPassIndispo, float tarifPass, FestivalStatus status, List<CovoiturageDTO> covoiturages, CommuneDTO id_commune, DomaineDTO id_domaine) {
        this.id_festival = id_festival;
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
        this.covoiturages = covoiturages;
        this.id_commune = id_commune;
        this.id_domaine = id_domaine;
    }
    
    private long id_festival;

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

    private List<CovoiturageDTO> covoiturages;

    private CommuneDTO id_commune;

    private DomaineDTO id_domaine;
}
