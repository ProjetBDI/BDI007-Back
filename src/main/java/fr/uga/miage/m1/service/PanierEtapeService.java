package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.PanierEtapeMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.repository.PanierEtapeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierEtapeService {

    @PersistenceContext
    private EntityManager entityManager;
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


    public  List<PanierEtapeDTO> getPanierByPanierEtape(Long idPanier) {
        TypedQuery<PanierEtape> query = entityManager.createQuery("From PanierEtape p Where p.idPanier.idPanier = :idPanier", PanierEtape.class);
        query.setParameter("idPanier", idPanier);
        // query.getSingleResult can't handle null return
        List<PanierEtape> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return panierEtapeMapper.entityToDTO(result);
    }

    // DELETE
    public void deleteById(Long id) {
        panierEtapeRepository.deleteById(id);
    }

    public void delete(PanierEtape panierEtape) {
        panierEtapeRepository.delete(panierEtape);
    }
}
