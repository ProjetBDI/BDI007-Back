package fr.uga.miage.m1.service;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.repository.PanierEtapeRepository;
=======
import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.mapper.PanierEtapeMapper;
import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.repository.PanierEtapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734

@Service
@RequiredArgsConstructor
public class PanierEtapeService {

    private final PanierEtapeRepository panierEtapeRepository;
    private final PanierEtapeMapper panierEtapeMapper;


    // SAVE
    public PanierEtapeDTO save(PanierEtapeDTO panierEtape) {
        return panierEtapeMapper.entityToDTO(panierEtapeRepository.save(panierEtapeMapper.dtoToEntity(panierEtape)));
    }

    // GET
    public PanierEtapeDTO getById(Long id) {
        return panierEtapeMapper.entityToDTO(panierEtapeRepository.findById(id).orElse(null));
    }

    public List<PanierEtapeDTO> getAllPanierEtapes() {
        return panierEtapeMapper.entityToDTO(panierEtapeRepository.findAll());
    }

    // DELETE
    public void deleteById(Long id) {
        panierEtapeRepository.deleteById(id);
    }

    public void delete(PanierEtape panierEtape) {
        panierEtapeRepository.delete(panierEtape);
    }
}
