package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DomaineDTO {

    private int id_domaine;
    
    private String nomDomaine;

    private String sousDomaines;

    private List<FestivalDTO> festivals;
}
