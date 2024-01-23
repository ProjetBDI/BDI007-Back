package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.model.Utilisateur;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    Utilisateur dtoToEntity(UtilisateurDTO utilisateurDTO);

<<<<<<< HEAD
    UtilisateurDTO entityToDTO(Utilisateur utilisateur);
=======
    // @Mapping(target = "motDePasse", ignore = true) // Ignorer le mot de passe lors de la conversion
    UtilisateurDTO utilisateurToDTO(Utilisateur utilisateur);
>>>>>>> 80b8473cd26de2e8722b899d8355a2fe007d561e

    List<Utilisateur> dtoToEntity(List<UtilisateurDTO> utilisateurDTOs);

    List<UtilisateurDTO> entityToDTO(List<Utilisateur> utilisateurs);
}

