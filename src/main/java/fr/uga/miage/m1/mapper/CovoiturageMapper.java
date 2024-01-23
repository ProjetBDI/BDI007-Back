package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.model.Covoiturage;

import java.util.List;

public interface CovoiturageMapper {
    CovoiturageDTO entityToDTO(Covoiturage covoiturage);

    List<CovoiturageDTO> entityToDTO(Iterable<Covoiturage> covoiturages);

    Covoiturage dtoToEntity(CovoiturageDTO covoiturage);

    List<Covoiturage> dtoToEntity(Iterable<CovoiturageDTO> covoiturages);
}
