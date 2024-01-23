package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SousDomaineDTO {
    
    private String nomSousDomaine;

    private DomaineDTO domaine;

    private List<FestivalDTO> festivals;
}
