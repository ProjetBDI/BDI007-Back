package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.mapper.EtapeMapper;
import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class EtapeService {

    @PersistenceContext
    private EntityManager entityManager;
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


    public List<EtapeDTO> getEtapesForFestivalById(Long idFestival) {
        TypedQuery<Etape> query = entityManager.createQuery("SELECT e From Festival f join Covoiturage c on c.idFestival=f.idFestival join Etape e on e.idCovoiturage= c.idCovoiturage where f.idFestival = :idFestival", Etape.class);
        query.setParameter("idFestival", idFestival);
        List<Etape> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return etapeMapper.entityToDTO(result);
    }

    public List<EtapeDTO> getEtapesForFestivalByIdUsingPages(Long idFestival, int number) {
        TypedQuery<Etape> query = entityManager.createQuery("SELECT e From Festival f join Covoiturage c on c.idFestival=f.idFestival join Etape e on e.idCovoiturage= c.idCovoiturage where f.idFestival = :idFestival", Etape.class);
        query.setParameter("idFestival", idFestival);
        List<Etape> result = query.getResultList();
        int pageSize = 10;
        query.setFirstResult((number - 1) * pageSize);
        query.setMaxResults(pageSize);
        if (result.isEmpty()) {
            return null;
        }
        return etapeMapper.entityToDTO(result);
    }

    // DELETE
    public void deleteById(Long id) {
        etapeRepository.deleteById(id);
    }

    public void delete(Etape etape) {
        etapeRepository.delete(etape);
    }
}
