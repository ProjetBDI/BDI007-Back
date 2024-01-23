package fr.uga.miage.m1.dto;

import java.util.List;

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

    private String status;

    private List<CovoiturageDTO> covoiturages;

    private CommuneDTO commune;

    private SousDomaineDTO sousDomaine;
}
