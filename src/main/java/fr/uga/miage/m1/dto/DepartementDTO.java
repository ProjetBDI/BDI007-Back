package fr.uga.miage.m1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(name = "DepartementDTO", description = "DepartementDTO description")
public class DepartementDTO {

    public DepartementDTO(
        int id_departement,
        String numDepartement,
        String nomDepartement,
        String nomregion,
        List<CommuneDTO> communes
    ) {
        this.id_departement = id_departement;
        this.numDepartement = numDepartement;
        this.nomDepartement = nomDepartement;
        this.nomregion = nomregion;
        this.communes = communes;
    }
    
    private int id_departement;

    private String numDepartement;

    private String nomDepartement;

    private String nomregion;

    private List<CommuneDTO> communes;

}
