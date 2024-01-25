package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "CovoiturageDTO", description = "CovoiturageDTO description")
public class CovoiturageDTO {

    public CovoiturageDTO(
        long idCovoiturage,
        int nbPlace,
        int nbPlaceDispo,
        String marque,
        String modele,
        String couleur,
        Date dateDepart,
        List<EtapeDTO> etapes,
        FestivalDTO idFestival,
        UtilisateurDTO idConducteur
    ) {
        this.idCovoiturage = idCovoiturage;
        this.nbPlace = nbPlace;
        this.nbPlaceDispo = nbPlaceDispo;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.dateDepart = dateDepart;
        this.etapes = etapes;
        this.idFestival = idFestival;
        this.idConducteur = idConducteur;
    }

    private long idCovoiturage;

    private int nbPlace;
    
    private int nbPlaceDispo;
    
    private String marque;
    
    private String modele;
    
    private String couleur;
    
    private Date dateDepart;
    
    private List<EtapeDTO> etapes;
    
    private FestivalDTO idFestival;
    
    private UtilisateurDTO idConducteur;
}
