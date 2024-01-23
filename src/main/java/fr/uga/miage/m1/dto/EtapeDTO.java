package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.model.Lieu;
import fr.uga.miage.m1.model.PanierEtape;

import java.util.List;

public class EtapeDTO {

    private long idLieu;

    private long idCovoiturage;
    
    private float prixEtape;
    
    private int dureeDepuisDepart;
    
    private LieuDTO lieu;
    
    private CovoiturageDTO covoiturage;
    
    private List<PanierEtapeDTO> panierEtapes;
}