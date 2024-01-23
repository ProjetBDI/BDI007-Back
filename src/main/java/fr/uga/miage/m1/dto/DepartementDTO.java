package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartementDTO {
    
    private String departement;

    private String nomDepartement;

    private List<CommuneDTO> communes;

    private RegionDTO nomregion;
}
