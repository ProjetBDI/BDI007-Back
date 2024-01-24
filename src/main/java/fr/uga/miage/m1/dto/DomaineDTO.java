package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DomaineDTO {

    public DomaineDTO(
        int id_domaine,
        String nomDomaine,
        String sousDomaines,
        List<FestivalDTO> festivals
    ) {
        this.id_domaine = id_domaine;
        this.nomDomaine = nomDomaine;
        this.sousDomaines = sousDomaines;
        this.festivals = festivals;
    }

    private int id_domaine;
    
    private String nomDomaine;

    private String sousDomaines;

    private List<FestivalDTO> festivals;
}
