package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RegionDTO {
    
    private String nom;

    private List<DepartementDTO> departements;
}
