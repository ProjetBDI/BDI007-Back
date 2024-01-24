package fr.uga.miage.m1.dto;

import fr.uga.miage.m1.enums.TypeLieu;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LieuDTO {

    public LieuDTO(
        long id_lieu,
        String adresse,
        String codeINSEELieu,
        float latitude,
        float longitude,
        String nom,
        TypeLieu typeLieu,
        CommuneDTO id_commune,
        List<EtapeDTO> etapes
    ) {
        this.id_lieu = id_lieu;
        this.adresse = adresse;
        this.codeINSEELieu = codeINSEELieu;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
        this.typeLieu = typeLieu;
        this.id_commune = id_commune;
        this.etapes = etapes;
    }
    
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
