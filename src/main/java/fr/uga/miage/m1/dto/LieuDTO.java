package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.TypeLieu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(name = "LieuDTO", description = "LieuDTO description")
public class LieuDTO {
    
    private long idLieu;

    private String adresse;

    private String codeINSEELieu;

    private float latitude;

    private float longitude;

    private String nom;

    private TypeLieu typeLieu;

    private CommuneDTO idCommune;

}
