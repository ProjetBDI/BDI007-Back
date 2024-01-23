package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.model.Utilisateur;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    Utilisateur dtoToEntity(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO entityToDTO(Utilisateur utilisateur);

    List<Utilisateur> dtoToEntity(List<UtilisateurDTO> utilisateurDTOs);

    List<UtilisateurDTO> entityToDTO(List<Utilisateur> utilisateurs);
}

