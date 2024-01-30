package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.model.Commune;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={DepartementMapper.class})
public interface CommuneMapper{
    CommuneDTO entityToDTO(Commune commune);

    List<CommuneDTO> entityToDTO(Iterable<Commune> communes);

    Commune dtoToEntity(CommuneDTO commune);

    List<Commune> dtoToEntity(Iterable<CommuneDTO> communes);
}

