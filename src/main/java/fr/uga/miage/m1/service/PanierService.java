package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.repository.PanierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    @PersistenceContext
    private final EntityManager entityManager;
    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper;

    // SAVE
    public PanierDTO save(PanierDTO panier) {
        return panierMapper.entityToDTO(panierRepository.save(panierMapper.dtoToEntity(panier)));
    }

    // GET
    public List<PanierDTO> getAllPaniers() {
        return panierMapper.entityToDTO(panierRepository.findAll());
    }

    public PanierDTO getById(Long id) {
        return panierMapper.entityToDTO(panierRepository.findById(id).orElse(null));
    }

    public PanierDTO getCurrentPanierByUtilisateurId(Long idUtilisateur) {
        TypedQuery<Panier> query = entityManager.createQuery("From Panier p Where p.datePaiement = null and p.idProprietaire.idUtilisateur = :idUtilisateur", Panier.class);
        query.setParameter("idUtilisateur", idUtilisateur);
        // query.getSingleResult can't handle null return
        List<Panier> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        if (result.size() > 1) {
            throw new NotFoundException("Panier", "idUtilisateur", idUtilisateur);
        }
        return panierMapper.entityToDTO(result.get(0));
    }

    // DELETE
    public void deleteById(Long id) {
        panierRepository.deleteById(id);
    }

    public void delete(Panier panier) {
        panierRepository.delete(panier);
    }
}
