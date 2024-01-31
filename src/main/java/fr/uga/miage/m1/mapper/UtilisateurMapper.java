package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.model.Utilisateur;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PanierMapper.class, CovoiturageMapper.class})
public interface UtilisateurMapper {

    Utilisateur dtoToEntity(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO entityToDTO(Utilisateur utilisateur);

    List<Utilisateur> dtoToEntity(List<UtilisateurDTO> utilisateurDTOs);

    List<UtilisateurDTO> entityToDTO(List<Utilisateur> utilisateurs);

}

