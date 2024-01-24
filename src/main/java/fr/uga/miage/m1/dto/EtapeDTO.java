package fr.uga.miage.m1.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EtapeDTO {

    public EtapeDTO(
        long id_etape,
        float prixEtape,
        int dureeDepuisDepart,
        LieuDTO id_lieu,
        CovoiturageDTO id_covoiturage,
        List<PanierEtapeDTO> panierEtapes
    ) {
        this.id_etape = id_etape;
        this.prixEtape = prixEtape;
        this.dureeDepuisDepart = dureeDepuisDepart;
        this.id_lieu = id_lieu;
        this.id_covoiturage = id_covoiturage;
        this.panierEtapes = panierEtapes;
    }

    private long id_etape;

    private float prixEtape;

    private int dureeDepuisDepart;

    private LieuDTO id_lieu;

    private CovoiturageDTO id_covoiturage;
    
    private List<PanierEtapeDTO> panierEtapes;
}
