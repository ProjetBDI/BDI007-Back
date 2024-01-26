package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.model.Domaine;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = FestivalMapper.class)
public interface DomaineMapper {
    //@Mapping(target = "testInt", source = ".", qualifiedBy = )
    //@Mapping(target = "fieldMapping", source = "fieldNotMappingAutomatically")
    DomaineDTO entityToDTO(Domaine domaine);

    List<DomaineDTO> entityToDTO(Iterable<Domaine> domaines);

    Domaine dtoToEntity(DomaineDTO domaine);

    List<Domaine> dtoToEntity(Iterable<DomaineDTO> domaines);
}
