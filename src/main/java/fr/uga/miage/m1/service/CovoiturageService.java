package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.error.NotEnoughtPlacesException;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.CovoiturageMapper;
import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.repository.CovoiturageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
@Data
@RequiredArgsConstructor
@Log
public class CovoiturageService {
    @PersistenceContext
    private EntityManager entityManager;
    private final CovoiturageRepository covoiturageRepository;
    private final CovoiturageMapper covoiturageMapper;


    // SAVE
    public void save(CovoiturageDTO covoiturage) {
        covoiturageRepository.save(covoiturageMapper.dtoToEntity(covoiturage));
    }

    public CovoiturageDTO getById(Long id) {
        return covoiturageMapper.entityToDTO(covoiturageRepository.findById(id).orElse(null));
    }


    // GET
    public List<Covoiturage> getAllCovoiturages() {
        return covoiturageRepository.findAll();
    }

    public List<CovoiturageDTO> getAllCovoituragesUsingPages(int number) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage", Covoiturage.class);
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        return covoiturageMapper.entityToDTO(query.getResultList());
    }


    public List<CovoiturageDTO> getFestivalById(Long idFestival) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage c Where c.idFestival.idFestival = :idFestival", Covoiturage.class);
        query.setParameter("idFestival", idFestival);
        List<Covoiturage> result = query.getResultList();

        return result.isEmpty() ? Collections.emptyList() : covoiturageMapper.entityToDTO(result);
    }


    public List<CovoiturageDTO> getAllCovoituragesByFestivalUsingPages(int number, Long idFestival) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage c Where c.idFestival.idFestival = :idFestival", Covoiturage.class);
        int pageSize = 10;
        query.setParameter("idFestival", idFestival);
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        return covoiturageMapper.entityToDTO(query.getResultList());
    }

    // DELETE
    public void deleteById(Long id) {
        covoiturageRepository.deleteById(id);
    }

    public void delete(Covoiturage covoiturage) {
        covoiturageRepository.delete(covoiturage);
    }

    @Transactional
    public boolean checkBeforePaymentAndUpdate(Long idCovoiturage, int nbPlacesPrises) {
        TypedQuery<Covoiturage> query = entityManager.createQuery("From Covoiturage c Where c.idCovoiturage = :idCovoiturage", Covoiturage.class);
        query.setParameter("idCovoiturage", idCovoiturage);
        List<Covoiturage> result = query.getResultList();
        if (result.isEmpty() || result.size() > 1) {
            throw new NotFoundException("Covoiturage", "idCovoiturage", idCovoiturage);
        }
        CovoiturageDTO covoiturage = covoiturageMapper.entityToDTO(result.get(0));
        if (covoiturage.getNbPlaceDispo() < nbPlacesPrises) {
            throw new NotEnoughtPlacesException("Covoiturage", "nbPlacesDispo", nbPlacesPrises, covoiturage.getNbPlaceDispo());
        }
        Query updateQuery = entityManager.createNativeQuery("Update Covoiturage c set c.nb_place_dispo = c.nb_place_dispo - :nbPlacesPrises Where c.id_covoiturage = :idCovoiturage");
        updateQuery.setParameter("nbPlacesPrises", nbPlacesPrises);
        updateQuery.setParameter("idCovoiturage", idCovoiturage);
        int res = updateQuery.executeUpdate();
        return res == 1;
    }
}
