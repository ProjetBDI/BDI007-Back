package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "DomaineDTO", description = "DomaineDTO description")
public class DomaineDTO {

    public DomaineDTO(
        int idDomaine,
        String nomDomaine,
        String sousDomaines,
        List<FestivalDTO> festivals
    ) {
        this.idDomaine = idDomaine;
        this.nomDomaine = nomDomaine;
        this.sousDomaines = sousDomaines;
        this.festivals = festivals;
    }

    private int idDomaine;
    
    private String nomDomaine;

    private String sousDomaines;

    private List<FestivalDTO> festivals;
}
