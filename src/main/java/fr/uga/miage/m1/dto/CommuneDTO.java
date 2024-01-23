package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.model.Lieu;

import java.util.List;

public class CommuneDTO {

    private String codeINSEE;
    private String nomCommune;
    private String codePostal;
    private String longitude;
    private String latitude;
    private Collection<FestivalDTO> festivals;
    private Collection<LieuDTO> lieux;
    private DepartementDTO departement;
    
}