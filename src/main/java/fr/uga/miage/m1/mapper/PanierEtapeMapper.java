package fr.uga.miage.m1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.model.PanierEtape;

@Mapper(componentModel = "spring")
public interface PanierEtapeMapper {
    
    PanierEtape dtoToEntity(PanierEtapeDTO panierEtapeDTO);

    PanierEtapeDTO entityToDTO(PanierEtape panierEtape);

    List<PanierEtape> dtoToEntity(List<PanierEtapeDTO> panierEtapeDTOs);

    List<PanierEtapeDTO> entityToDTO(List<PanierEtape> panierEtapes);
}