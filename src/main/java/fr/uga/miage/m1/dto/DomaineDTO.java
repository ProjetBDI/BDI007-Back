package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DomaineDTO {
    
    private String nomDomaine;

    private List<SousDomaineDTO> sousDomaines;
}
