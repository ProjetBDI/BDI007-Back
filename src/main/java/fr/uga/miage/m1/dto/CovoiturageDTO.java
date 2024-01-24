package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CovoiturageDTO {

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
