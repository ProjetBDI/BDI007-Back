package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.repository.PanierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    @PersistenceContext
    private final EntityManager entityManager;
    private final PanierRepository panierRepository;

    @Autowired
    private final PanierMapper panierMapper;

    // SAVE
    public Panier save(Panier panier) {
        return panierRepository.save(panier);
    }

    // GET
    public Iterable<Panier> getAllPaniers() {
        return panierRepository.findAll();
    }

    public Panier getById(Long id) {
        return panierRepository.findById(id).get();
    }

    public PanierDTO getCurrentPanierByUtilisateurId(Long idUtilisateur) {
        TypedQuery<Panier> query = entityManager.createQuery("From Panier p Where p.datePaiement = null and p.idProprietaire.idUtilisateur = :idUtilisateur", Panier.class);
        query.setParameter("idUtilisateur", idUtilisateur);
        List<Panier> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        if (result.size() > 1) {
            throw new RuntimeException("Plusieurs paniers en cours pour l'utilisateur " + idUtilisateur);
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
