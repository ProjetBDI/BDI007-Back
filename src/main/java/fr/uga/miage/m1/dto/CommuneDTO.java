package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommuneDTO {

    private String codeINSEE;
    
    private String nomCommune;
    
    private String codePostal;
    
    private String longitude;
    
    private String latitude;
    
    private List<FestivalDTO> festivals;
    
    private List<LieuDTO> lieux;
    
    private DepartementDTO departement;
    
}