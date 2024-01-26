package fr.uga.miage.m1.service;

import java.util.List;
import java.util.Optional;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.Commune;
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

    public CommuneDTO getById(Long id) {
    return communeMapper.entityToDTO(communeRepository.findById(id).get());
}

    public List<CommuneDTO> getAllCommunes() {
        return communeMapper.entityToDTO(communeRepository.findAll());
    }

    public void saveCommune(Commune commune) {
        communeRepository.save(commune);
    }

    public void deleteById(Long id) {
        communeRepository.deleteById(id);
    }

    public void delete(Commune commune) {
        communeRepository.delete(commune);
    }

}
