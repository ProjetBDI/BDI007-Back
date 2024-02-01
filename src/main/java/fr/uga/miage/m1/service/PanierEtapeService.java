package fr.uga.miage.m1.service;

import fr.uga.miage.m1.controller.create.PanierEtapeCreate;
import fr.uga.miage.m1.controller.create.PanierEtapeUpdate;
import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.PanierEtapeMapper;
import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.repository.PanierEtapeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class PanierEtapeService {

    @PersistenceContext
    private EntityManager entityManager;
    private final PanierEtapeRepository panierEtapeRepository;
    private final PanierEtapeMapper panierEtapeMapper;
    private static final String PANIER_ETAPE = PANIER_ETAPE;

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


    public List<PanierEtapeDTO> getPanierByPanierEtape(Long idPanier) {
        TypedQuery<PanierEtape> query = entityManager.createQuery("From PanierEtape p Where p.idPanier.idPanier = :idPanier", PanierEtape.class);
        query.setParameter("idPanier", idPanier);
        // query.getSingleResult can't handle null return
        List<PanierEtape> result = query.getResultList();

        return result.isEmpty() ? Collections.emptyList() :  panierEtapeMapper.entityToDTO(result);
    }

    // DELETE
    public void deleteById(Long id) {
        panierEtapeRepository.deleteById(id);
    }

    public void delete(PanierEtape panierEtape) {
        panierEtapeRepository.delete(panierEtape);
    }

    @Transactional
    public List<PanierEtapeDTO> saveCustom(List<PanierEtapeCreate> panierEtapeCreate) {
        for (PanierEtapeCreate panierEtape : panierEtapeCreate) {
            log.info("panierEtape : " + panierEtape);
            entityManager.createNativeQuery("INSERT INTO panier_etape (id_panier_etape, id_panier, id_etape, NB_PLACE_OCCUPPE) VALUES (panier_etape_id_sequence.nextval ,:id_panier, :id_etape, :nb_place_occuppe)")
                    .setParameter("id_panier", panierEtape.getIdPanier())
                    .setParameter("id_etape", panierEtape.getIdEtape())
                    .setParameter("nb_place_occuppe", panierEtape.getNbPlaceOccuppe())
                    .executeUpdate();
        }
        TypedQuery<PanierEtape> querySelect = entityManager.createQuery("From PanierEtape ORDER BY idPanierEtape DESC LIMIT :number", PanierEtape.class);
        querySelect.setParameter("number", panierEtapeCreate.size());
        List<PanierEtape> result = querySelect.getResultList();

        for (PanierEtape panierEtape : result) {
            if (panierEtapeCreate.stream().noneMatch(
                    p -> p.getIdPanier().equals(panierEtape.getIdPanier().getIdPanier()) && p.getIdEtape().equals(panierEtape.getIdEtape().getIdEtape()))) {
                throw new NotFoundException(PANIER_ETAPE, "idPanier", panierEtape.getIdPanier().getIdPanier());
            }
        }

        return result.isEmpty() ? Collections.emptyList() : panierEtapeMapper.entityToDTO(result);
    }

    @Transactional
    public PanierEtapeDTO updateNbPlace(PanierEtapeUpdate panierEtapeDTO) {

        PanierEtape panierEtape = panierEtapeRepository.findById(panierEtapeDTO.getIdPanierEtape()).orElse(null);
        if (panierEtape == null) {
            throw new NotFoundException(PANIER_ETAPE, "idPanierEtape", panierEtapeDTO.getIdPanierEtape());
        }
        Query query = entityManager.createNativeQuery("UPDATE panier_etape SET NB_PLACE_OCCUPPE = :nb_place_occuppe WHERE id_panier_etape = :id_panier_etape");
        query.setParameter("nb_place_occuppe", panierEtapeDTO.getNbPlaceOccuppe());
        query.setParameter("id_panier_etape", panierEtapeDTO.getIdPanierEtape());
        int result = query.executeUpdate();
        if (result == 0) {
            throw new NotFoundException(PANIER_ETAPE, "idPanierEtape", panierEtapeDTO.getIdPanierEtape());
        }
        return panierEtapeMapper.entityToDTO(panierEtape);

    }
}
