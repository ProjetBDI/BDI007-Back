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
        long id_covoiturage,
        int nbPlace,
        int nbPlaceDispo,
        String marque,
        String modele,
        String couleur,
        Date dateDepart,
        List<EtapeDTO> etapes,
        FestivalDTO id_festival,
        UtilisateurDTO id_conducteur
    ) {
        this.id_covoiturage = id_covoiturage;
        this.nbPlace = nbPlace;
        this.nbPlaceDispo = nbPlaceDispo;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.dateDepart = dateDepart;
        this.etapes = etapes;
        this.id_festival = id_festival;
        this.id_conducteur = id_conducteur;
    }

    private long id_covoiturage;

    private int nbPlace;
    
    private int nbPlaceDispo;
    
    private String marque;
    
    private String modele;
    
    private String couleur;
    
    private Date dateDepart;
    
    private List<EtapeDTO> etapes;
    
    private FestivalDTO id_festival;
    
    private UtilisateurDTO id_conducteur;
}
