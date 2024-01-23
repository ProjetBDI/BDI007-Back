package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.model.Utilisateur;

import java.util.Date;
import java.util.List;

public class CovoiturageDTO {

    private long idCovoiturage;
    private int nbPlace;
    private int nbPlaceDispo;
    private String marque;
    private String modele;
    private String couleur;
    private Date dateDepart;
    private List<EtapeDTO> etapes;
    private FestivalDTO festival;
    private UtilisateurDTO conducteur;
}
