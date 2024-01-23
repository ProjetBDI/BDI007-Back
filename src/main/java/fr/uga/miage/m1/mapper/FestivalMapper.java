package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.model.Festival;

import java.util.List;

public interface FestivalMapper {
    FestivalDTO entityToDTO(Festival festival);

    List<FestivalDTO> entityToDTO(Iterable<Festival> festivals);

    Festival dtoToEntity(FestivalDTO festival);

    List<Festival> dtoToEntity(Iterable<FestivalDTO> festivals);
}
