package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.mapper.DomaineMapper;
import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.repository.DomaineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomaineService {

    private final DomaineRepository domaineRepository;
    private final DomaineMapper domaineMapper;

    // SAVE
    public DomaineDTO save(DomaineDTO domaine) {
        return domaineMapper.entityToDTO(domaineRepository.save(domaineMapper.dtoToEntity(domaine)));
    }

    // GET
    public DomaineDTO getById(Long id) {
        return domaineMapper.entityToDTO(domaineRepository.findById(id).orElse(null));
    }


    public void delete(Long id) {
        domaineRepository.deleteById(id);
    }

    public void delete(Domaine domaine) {
        domaineRepository.delete(domaine);
    }

    //get All
    public List<Domaine> getAllDomaines() {
        return domaineRepository.findAll();
    }
}
