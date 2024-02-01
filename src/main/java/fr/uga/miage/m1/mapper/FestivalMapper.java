package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.model.Festival;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses={CommuneMapper.class, DomaineMapper.class})
public interface FestivalMapper {

    FestivalDTO entityToDTO(Festival festival);

    List<FestivalDTO> entityToDTO(Iterable<Festival> festivals);

    Festival dtoToEntity(FestivalDTO festival);

    List<Festival> dtoToEntity(Iterable<FestivalDTO> festivals);
}
