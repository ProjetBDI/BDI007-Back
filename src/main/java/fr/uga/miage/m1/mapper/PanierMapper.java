package fr.uga.miage.m1.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.model.Panier;

@Mapper(componentModel = "spring", uses = {PanierEtapeMapper.class, UtilisateurMapper.class})
public interface PanierMapper {
    
    Panier dtoToEntity(PanierDTO panierDTO);

    PanierDTO entityToDTO(Panier panier);

    List<Panier> dtoToEntity(List<PanierDTO> panierDTOs);

    List<PanierDTO> entityToDTO(List<Panier> paniers);
}
