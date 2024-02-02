package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.repository.CommuneRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class CommuneService {

    private final CommuneRepository communeRepository;
    private final CommuneMapper communeMapper;

    // Version pour Sonar
    public CommuneDTO getById(Long id) {
        return communeRepository.findById(id)
                .map(communeMapper::entityToDTO)
                .orElseThrow(() -> new NotFoundException("Commune", "id", id));
    }


    public List<CommuneDTO> getAllCommunes() {
        return communeMapper.entityToDTO(communeRepository.findAll());
    }

    public List<CommuneDTO> getByNom(String nom) {
        return communeMapper.entityToDTO(communeRepository.findByNomCommune(nom));
    }

    public void deleteById(Long id) {
        communeRepository.deleteById(id);
    }

    public void delete(Commune commune) {
        communeRepository.delete(commune);
    }
}
