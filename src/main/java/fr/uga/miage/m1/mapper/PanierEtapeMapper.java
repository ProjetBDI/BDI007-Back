package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.model.PanierEtape;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EtapeMapper.class, PanierMapper.class})
public interface PanierEtapeMapper {

    PanierEtape dtoToEntity(PanierEtapeDTO panierEtapeDTO);

    PanierEtapeDTO entityToDTO(PanierEtape panierEtape);

    List<PanierEtape> dtoToEntity(Iterable<PanierEtapeDTO> panierEtapeDTOs);

    List<PanierEtapeDTO> entityToDTO(Iterable<PanierEtape> panierEtapes);
}
