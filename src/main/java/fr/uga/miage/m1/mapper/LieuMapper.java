package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.LieuDTO;
import fr.uga.miage.m1.model.Lieu;

import java.util.List;

public interface LieuMapper {
    LieuDTO entityToDTO(Lieu lieu);

    List<LieuDTO> entityToDTO(Iterable<Lieu> lieux);

    Lieu dtoToEntity(LieuDTO lieu);

    List<Lieu> dtoToEntity(Iterable<LieuDTO> lieux);
}