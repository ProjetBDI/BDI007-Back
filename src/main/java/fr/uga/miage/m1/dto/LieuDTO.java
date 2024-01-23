package fr.uga.miage.m1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LieuDTO {
    
    private Long idLieu;

    private String codeINSEELieu;

    private String typeLieu;

    private String nom;

    private String adresse;

    private float longitude;

    private float latitude;

    private CommuneDTO commune;

    private List<EtapeDTO> etapes;
}
