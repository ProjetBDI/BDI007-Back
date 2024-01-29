package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.CovoiturageMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.repository.CovoiturageRepository;

@Service
@Data
public class CovoiturageService {

    @Autowired
    private final CovoiturageRepository covoiturageRepository;
    @Autowired
    private final CovoiturageMapper covoiturageMapper;

    public CovoiturageDTO getById(Long id) {
        return covoiturageRepository.findById(id)
                .map(covoiturageMapper::entityToDTO)
                .orElseThrow(() -> new NotFoundException("Covoiturage", "id", id));
    }

    // SAVE
    public void save(Covoiturage covoiturage) {
        covoiturageRepository.save(covoiturage);
    }



    // DELETE
    public void deleteById(Long id) {
        covoiturageRepository.deleteById(id);
    }

    public void delete(Covoiturage covoiturage) {
        covoiturageRepository.delete(covoiturage);
    }

    public Iterable<Covoiturage> getAllCovoiturages() {return covoiturageRepository.findAll();}
}
