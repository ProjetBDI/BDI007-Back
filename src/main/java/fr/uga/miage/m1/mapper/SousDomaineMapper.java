package fr.uga.miage.m1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.SousDomaineDTO;
import fr.uga.miage.m1.model.SousDomaine;

@Mapper(componentModel = "spring")
public interface SousDomaineMapper {
    
    SousDomaine dtoToEntity(SousDomaineDTO sousDomaineDTO);

    SousDomaineDTO entityToDTO(SousDomaine sousDomaine);

    List<SousDomaine> dtoToEntity(List<SousDomaineDTO> sousDomaineDTOs);

    List<SousDomaineDTO> entityToDTO(List<SousDomaine> sousDomaines);
}
