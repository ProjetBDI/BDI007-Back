package fr.uga.miage.m1.service;

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


    public Iterable<Commune> getCommunes() {
        return communeRepository.findAll();
    }

    public void deleteCommune(final Long id) {
        communeRepository.deleteById(id);
    }

    public Commune saveCommune(Commune commune) {
        Commune savedCommune = communeRepository.save(commune);
        return savedCommune;
    }
}
