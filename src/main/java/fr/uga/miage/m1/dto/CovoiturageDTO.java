package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@Schema(name = "CovoiturageDTO", description = "CovoiturageDTO description")
public class CovoiturageDTO {

    private long idCovoiturage;

    private int nbPlace;

    private int nbPlaceDispo;

    private String marque;

    private String modele;

    private String couleur;

    private Date dateDepart;

    private FestivalDTO idFestival;

    private UtilisateurDTO idConducteur;
}