package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.CovoiturageMapper;
import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.repository.CovoiturageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
@RequiredArgsConstructor
public class CovoiturageService {
    @PersistenceContext // or even @Autowired
    private EntityManager entityManager;

    @Autowired
    private final CovoiturageRepository covoiturageRepository;

    @Autowired
    private final CovoiturageMapper covoiturageMapper;


    // SAVE
    public void save(Covoiturage covoiturage) {
        covoiturageRepository.save(covoiturage);
    }

    public CovoiturageDTO getById(Long id) {
        return covoiturageRepository.findById(id)
                .map(covoiturageMapper::entityToDTO)
                .orElseThrow(() -> new NotFoundException("Covoiturage", "id", id));
    }

    // DELETE
    public void deleteById(Long id) {
        covoiturageRepository.deleteById(id);
    }

    public void delete(Covoiturage covoiturage) {
        covoiturageRepository.delete(covoiturage);
    }

    public Iterable<Covoiturage> getAllCovoiturages() {
        return covoiturageRepository.findAll();
    }

    public List<CovoiturageDTO> getAllCovoituragesUsingPages(int number) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage", Covoiturage.class);
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        return covoiturageMapper.entityToDTO(query.getResultList());
    }

    public List<CovoiturageDTO> getAllCovoituragesByFestivalUsingPages(int number, Long idFestival) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage c Where c.idFestival.idFestival = :idFestival", Covoiturage.class);
        int pageSize = 10;
        query.setParameter("idFestival", idFestival);
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        return covoiturageMapper.entityToDTO(query.getResultList());
    }
}
