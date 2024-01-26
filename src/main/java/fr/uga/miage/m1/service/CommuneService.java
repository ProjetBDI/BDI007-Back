package fr.uga.miage.m1.service;

import java.util.List;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.repository.CommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class CommuneService {

    @Autowired
    private final CommuneRepository communeRepository;
    @Autowired
    private final CommuneMapper communeMapper;
    // Version pour Sonar [
    public CommuneDTO getById(Long id) {
        return communeRepository.findById(id)
                .map(communeMapper::entityToDTO)
                .orElseThrow(() -> new NotFoundException("Commune", "id", id));
    }
    // Version pour sonar ]


    public List<CommuneDTO> getAllCommunes() {
        return communeMapper.entityToDTO(communeRepository.findAll());
    }

    public List<CommuneDTO> getByNom(String nom) {
        return communeMapper.entityToDTO(communeRepository.findByNomCommune(nom));
    }

}
