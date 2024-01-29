package fr.uga.miage.m1.service;


import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class FestivalService {

    @PersistenceContext // or even @Autowired
    private EntityManager entityManager;

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

    public List<FestivalDTO> getAllFestivalsUsingPages(int number) {
        Query query = entityManager.createQuery("From Festival");
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Festival> festivals = query.getResultList();
        return festivalMapper.entityToDTO(festivals);
    }

    public List<FestivalDTO> getAllFestivalsByNameUsingPages(String name, int number) {
        Query query = entityManager.createQuery("From Festival f where upper(f.nom) like upper(:name)");
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        query.setParameter("name", "%" + name + "%");
        log.info("Name : " + name);
        List<Festival> festivals = query.getResultList();
        return festivalMapper.entityToDTO(festivals);
    }

    // DELETE
    public void deleteById(Long id) {
        festivalRepository.deleteById(id);
    }

    public void delete(Festival festival) {
        festivalRepository.delete(festival);
    }
}
