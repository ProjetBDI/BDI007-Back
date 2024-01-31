package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.repository.PanierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    @PersistenceContext
    private final EntityManager entityManager;
    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper;
    private final EmailService emailService;

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

    //post payer
    public boolean postPayer(Long idPanier) throws IOException {
        TypedQuery<Void> query = entityManager.createQuery("Update Panier p set p.date_paiement = CURRENT_TIMESTAMP  Where p.idPanier = :idPanier", Void.class);
        query.setParameter("idPanier", idPanier);
        // query.getSingleResult can't handle null return
        int result = query.executeUpdate();
        if (result !=1 ) {
            return false;
        }
        TypedQuery<String> proprietaireQuery = entityManager.createQuery("SELECT u.email From Panier p join Utilisateur u ON  u.idUtilisateur=p.idProprietaire  Where p.idPanier= :idPanier", String.class);

        proprietaireQuery.setParameter("idPanier", idPanier);

        TypedQuery<String> covoitureursQuery = entityManager.createQuery("SELECT u.email From Panier p join PanierEtape pe on pe.idPanier=p.idPanier join Etape e on e.idEtape=pe.idEtape join Covoiturage c on c.idCovoiturage = e.idCovoiturage join Utilisateur u ON  u.idUtilisateur=c.idConducteur  Where p.idPanier= :idPanier", String.class);

        covoitureursQuery.setParameter("idPanier", idPanier);

        String proprio = proprietaireQuery.getResultList().get(0);
        List<String> covoits = covoitureursQuery.getResultList();

        emailService.envoyerEmail(proprio, "Votre panier a été payé", "Votre panier a été payé");
        emailService.envoyerEmail(covoits, "Votre panier a été payé", "Votre panier a été payé");
        return true;
    }

    // DELETE
    public void deleteById(Long id) {
        panierRepository.deleteById(id);
    }

    public void delete(Panier panier) {
        panierRepository.delete(panier);
    }
}
