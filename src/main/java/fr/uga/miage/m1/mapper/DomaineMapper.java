package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.model.Domaine;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

<<<<<<< HEAD
@Mapper(componentModel = "spring", uses ={FestivalMapper.class})
=======
@Mapper(componentModel = "spring", uses = FestivalMapper.class)
>>>>>>> 53152617b98430533fbcf796d9a2f290100700d1
public interface DomaineMapper {
    //@Mapping(target = "testInt", source = ".", qualifiedBy = )
    //@Mapping(target = "fieldMapping", source = "fieldNotMappingAutomatically")
    DomaineDTO entityToDTO(Domaine domaine);

    List<DomaineDTO> entityToDTO(Iterable<Domaine> domaines);

    Domaine dtoToEntity(DomaineDTO domaine);

    List<Domaine> dtoToEntity(Iterable<DomaineDTO> domaines);
}
