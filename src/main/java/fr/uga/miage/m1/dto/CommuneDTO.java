package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "CommuneDTO", description = "CommuneDTO description")
public class CommuneDTO {

    public CommuneDTO(
        long idCommune,
        String codeINSEE,
        String codePostal,
        String latitude,
        String longitude,
        String nomCommune,
        DepartementDTO idDepartement,
        List<FestivalDTO> festivals,
        List<LieuDTO> lieux
    ) {
        this.idCommune = idCommune;
        this.codeINSEE = codeINSEE;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomCommune = nomCommune;
        this.idDepartement = idDepartement;
        this.festivals = festivals;
        this.lieux = lieux;
    }

    private long idCommune;

    private String codeINSEE;

    private String codePostal;

    private String latitude;

    private String longitude;

    private String nomCommune;

    private DepartementDTO idDepartement;

    private List<FestivalDTO> festivals;
    
    private List<LieuDTO> lieux;
    
}