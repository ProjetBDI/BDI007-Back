package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.model.Domaine;

import java.util.List;

public interface DomaineMapper {
    DomaineDTO entityToDTO(Domaine domaine);

    List<DomaineDTO> entityToDTO(Iterable<Domaine> domaines);

    Domaine dtoToEntity(DomaineDTO domaine);

    List<Domaine> dtoToEntity(Iterable<DomaineDTO> domaines);
}
