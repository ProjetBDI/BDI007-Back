package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.mapper.EtapeMapper;
import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtapeService {

    private final EtapeRepository etapeRepository;
    private final EtapeMapper etapeMapper;

    // SAVE
    public EtapeDTO save(EtapeDTO etape) {
        return etapeMapper.entityToDTO(etapeRepository.save(etapeMapper.dtoToEntity(etape)));
    }

    // GET
    public EtapeDTO getById(Long id) {
        return etapeMapper.entityToDTO(etapeRepository.findById(id).orElse(null));
    }


    public List<EtapeDTO> getAllEtapes() {
        return etapeMapper.entityToDTO(etapeRepository.findAll());
    }

    // DELETE
    public void deleteById(Long id) {
        etapeRepository.deleteById(id);
    }

    public void delete(Etape etape) {
        etapeRepository.delete(etape);
    }
}
