package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.model.Etape;

import java.util.List;

public interface EtapeMapper {
    EtapeDTO entityToDTO(Etape etape);

    List<EtapeDTO> entityToDTO(Iterable<Etape> etapes);

    Etape dtoToEntity(EtapeDTO etape);

    List<Etape> dtoToEntity(Iterable<EtapeDTO> etapes);
}