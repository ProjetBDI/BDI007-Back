package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.model.Commune;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommuneMapper {

    CommuneDTO entityToDTO(Commune entity);

    Collection<CommuneDTO> entityToDTO(Iterable<Commune> communes);

    Commune dtoToEntity(CommuneDTO commune);

    Collection<Commune> dtoToEntity(Iterable<CommuneDTO> communes);
}

