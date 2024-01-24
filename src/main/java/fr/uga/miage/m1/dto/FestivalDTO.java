package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.FestivalStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FestivalDTO {
    
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
