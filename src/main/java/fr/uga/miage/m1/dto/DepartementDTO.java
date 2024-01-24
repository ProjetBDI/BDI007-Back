package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartementDTO {
    
    private int id_departement;

    private String numDepartement;

    private String nomDepartement;

    private String nomregion;

    private List<CommuneDTO> communes;

}
