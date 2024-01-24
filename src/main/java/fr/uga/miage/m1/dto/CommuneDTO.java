package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CommuneDTO {

    public CommuneDTO(
        long id_commune,
        String codeINSEE,
        String codePostal,
        String latitude,
        String longitude,
        String nomCommune,
        DepartementDTO id_departement,
        List<FestivalDTO> festivals,
        List<LieuDTO> lieux
    ) {
        this.id_commune = id_commune;
        this.codeINSEE = codeINSEE;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomCommune = nomCommune;
        this.id_departement = id_departement;
        this.festivals = festivals;
        this.lieux = lieux;
    }

    private long id_commune;

    private String codeINSEE;

    private String codePostal;

    private String latitude;

    private String longitude;

    private String nomCommune;

    private DepartementDTO id_departement;

    private List<FestivalDTO> festivals;
    
    private List<LieuDTO> lieux;
    
}