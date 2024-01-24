package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.model.Departement;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartementMapper {
    DepartementDTO entityToDTO(Departement departement);

    List<DepartementDTO> entityToDTO(Iterable<Departement> departements);

    Departement dtoToEntity(DepartementDTO departement);

    List<Departement> dtoToEntity(Iterable<DepartementDTO> departements);
}
