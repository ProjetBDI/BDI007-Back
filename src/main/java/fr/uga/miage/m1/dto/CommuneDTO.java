package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommuneDTO {

    private long id_commune;

    private String codeINSEE;

    private String codePostal;

    private String latitude;

    private String longitude;

    private String nomCommune;

    private DepartementDTO id_departement;

    private List<FestivalDTO> festivals;
    
    private List<LieuDTO> lieux;
    
}