package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.TypeLieu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "LieuDTO", description = "LieuDTO description")
public class LieuDTO {

    public LieuDTO(
        long idLieu,
        String adresse,
        String codeINSEELieu,
        float latitude,
        float longitude,
        String nom,
        TypeLieu typeLieu,
        CommuneDTO idCommune
    ) {
        this.idLieu = idLieu;
        this.adresse = adresse;
        this.codeINSEELieu = codeINSEELieu;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        this.typeLieu = typeLieu;
        this.idCommune = idCommune;
    }
    
    private long idLieu;

    private String adresse;

    private String codeINSEELieu;

    private float latitude;

    private float longitude;

    private String nom;

    private TypeLieu typeLieu;

    private CommuneDTO idCommune;

}
