package fr.uga.miage.m1.service;


import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
        return festivalMapper.entityToDTO(festivalRepository.findById(id).orElse(null));
    }


    public List<FestivalDTO> getAllFestivals() {
        return festivalMapper.entityToDTO(festivalRepository.findAll());
    }

    public List<FestivalDTO> getAllFestivalsUsingPages(int number) {
        TypedQuery<Festival> query = entityManager.createQuery("From Festival", Festival.class);
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        return festivalMapper.entityToDTO(query.getResultList());
    }

    public List<FestivalDTO> getAllFestivalsByNameUsingPages(String name, int number) {
        TypedQuery<Festival> query = entityManager.createQuery("From Festival f where upper(f.nom) like upper(:name)", Festival.class);
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        query.setParameter("name", "%" + name + "%");
        log.info("Name : " + name);
        return festivalMapper.entityToDTO(query.getResultList());
    }

    // DELETE
    public void deleteById(Long id) {
        festivalRepository.deleteById(id);
    }

    public void delete(Festival festival) {
        festivalRepository.delete(festival);
    }
}
