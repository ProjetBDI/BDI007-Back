package fr.uga.miage.m1.service;


import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FestivalService {

    @Autowired
    private final FestivalRepository festivalRepository;

    @Autowired
    private final FestivalMapper festivalMapper;


    // SAVE
    public void save(Festival festival) {
        festivalRepository.save(festival);
    }

    // GET
    public FestivalDTO getById(Long id) {
        return festivalMapper.entityToDTO(festivalRepository.findById(id).get());
    }


    public Iterable<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }

    // DELETE
    public void deleteById(Long id) {
        festivalRepository.deleteById(id);
    }

    public void delete(Festival festival) {
        festivalRepository.delete(festival);
    }
}
