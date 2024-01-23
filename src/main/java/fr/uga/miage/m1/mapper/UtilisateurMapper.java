package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

    // @Mapping(target = "motDePasse", ignore = true) // Ignorer le mot de passe lors de la conversion
    // UtilisateurDTO utilisateurToDTO(Utilisateur utilisateur);

    Utilisateur dtoToUtilisateur(UtilisateurDTO utilisateurDTO);
}

