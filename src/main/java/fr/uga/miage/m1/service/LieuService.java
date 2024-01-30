package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.LieuDTO;
import fr.uga.miage.m1.mapper.LieuMapper;
import fr.uga.miage.m1.repository.LieuRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LieuService {

    private final LieuRepository lieuRepository;
    private final LieuMapper lieuMapper;


    // SAVE
    public LieuDTO save(LieuDTO lieu) {
        return lieuMapper.entityToDTO(lieuRepository.save(lieuMapper.dtoToEntity(lieu)));
    }

    // GET
    public LieuDTO getById(Long id) {
        return lieuMapper.entityToDTO(lieuRepository.findById(id).orElse(null));
    }


    // DELETE
    public void deleteById(Long id) {
        lieuRepository.deleteById(id);
    }

    public void delete(LieuDTO lieu) {
        lieuRepository.delete(lieuMapper.dtoToEntity(lieu));
    }

    //get all
    public List<LieuDTO> getAllLieux() {
        return lieuMapper.entityToDTO(lieuRepository.findAll());
    }
}
