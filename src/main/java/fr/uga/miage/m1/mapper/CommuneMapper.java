package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.model.Commune;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses ={DepartementMapper.class})
public interface CommuneMapper{
    CommuneDTO entityToDTO(Commune commune);

    List<CommuneDTO> entityToDTO(Iterable<Commune> communes);

    Commune dtoToEntity(CommuneDTO commune);

    List<Commune> dtoToEntity(Iterable<CommuneDTO> communes);
}

