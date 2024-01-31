package fr.uga.miage.m1.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "EtapeDTO", description = "EtapeDTO description")
public class EtapeDTO {

    public EtapeDTO(
        long idEtape,
        float prixEtape,
        int dureeDepuisDepart,
        LieuDTO idLieu
    ) {
        this.idEtape = idEtape;
        this.prixEtape = prixEtape;
        this.dureeDepuisDepart = dureeDepuisDepart;
        this.idLieu = idLieu;
    }

    private long idEtape;

    private float prixEtape;

    private int dureeDepuisDepart;

    private LieuDTO idLieu;
}
