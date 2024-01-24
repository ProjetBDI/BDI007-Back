package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.TypeLieu;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LieuDTO {
    
    private long id_lieu;

    private String adresse;

    private String codeINSEELieu;

    private float latitude;

    private float longitude;

    private String nom;

    private TypeLieu typeLieu;

    private CommuneDTO id_commune;

    private List<EtapeDTO> etapes;
}
