package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.model.Departement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartementMapper {
    DepartementDTO entityToDTO(Departement departement);

    List<DepartementDTO> entityToDTO(Iterable<Departement> departements);

    Departement dtoToEntity(DepartementDTO departement);

    List<Departement> dtoToEntity(Iterable<DepartementDTO> departements);
}
