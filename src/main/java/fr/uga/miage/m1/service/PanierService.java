package fr.uga.miage.m1.service;

import fr.uga.miage.m1.controller.create.PanierCreate;
import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.repository.PanierRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PanierService {

    @PersistenceContext
    private final EntityManager entityManager;
    private final PanierRepository panierRepository;
    private final PanierMapper panierMapper;
    private final EmailService emailService;
    private static final String PANIER = "Panier";
    private static final String IDPANIER = "idPanier";

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
            throw new NotFoundException(PANIER, "idUtilisateur", idUtilisateur);
        }
        return panierMapper.entityToDTO(result.get(0));
    }

    //post payer
    @Transactional
    public PanierDTO postPayer(Long idPanier) throws IOException {
        Query query = entityManager.createNativeQuery("Update Panier p set p.date_paiement = CURRENT_TIMESTAMP  Where p.ID_Panier = :idPanier");
        query.setParameter(IDPANIER, idPanier);
        // query.getSingleResult can't handle null return
        int result = query.executeUpdate();
        if (result != 1) {
            return null;
        }
        TypedQuery<String> proprietaireQuery = entityManager.createQuery("SELECT u.email From Panier p join Utilisateur u ON  u.idUtilisateur=p.idProprietaire  Where p.idPanier= :idPanier", String.class);

        proprietaireQuery.setParameter(IDPANIER, idPanier);

        TypedQuery<String> covoitureursQuery = entityManager.createQuery("SELECT u.email From Panier p join PanierEtape pe on pe.idPanier=p.idPanier join Etape e on e.idEtape=pe.idEtape join Covoiturage c on c.idCovoiturage = e.idCovoiturage join Utilisateur u ON  u.idUtilisateur=c.idConducteur  Where p.idPanier= :idPanier", String.class);

        covoitureursQuery.setParameter(IDPANIER, idPanier);

        String proprio = proprietaireQuery.getResultList().get(0);
        List<String> covoits = covoitureursQuery.getResultList();

        emailService.envoyerEmail(proprio, "Paiement de votre festival", "Voici le récapitulatif de votre commande");
        emailService.envoyerEmail(covoits, "Place de covoiturage prise", "Vous avez de nouveaux covoitureurs !");
        return panierMapper.entityToDTO(panierRepository.findById(idPanier).orElse(null));
    }

    //save
    @Transactional
    public PanierDTO saveCustom(PanierCreate panierCreate) {
        Query query = entityManager.createNativeQuery("INSERT INTO Panier (id_panier, noms_festivaliers, id_proprietaire) VALUES (panier_id_sequence.nextval , :noms_festivaliers, :id_proprietaire)");
        query.setParameter("noms_festivaliers", panierCreate.getNomsFestivaliers());
        query.setParameter("id_proprietaire", panierCreate.getIdProprietaire());
        int res = query.executeUpdate();
        if (res == 1) {
            // find last insert
            TypedQuery<Panier> querySelect = entityManager.createQuery("From Panier ORDER BY idPanier DESC LIMIT 1", Panier.class);
            List<Panier> result = querySelect.getResultList();
            if (result.isEmpty()) {
                return null;
            }
            if (result.size() > 1) {
                throw new NotFoundException(PANIER, "idProprietaire", panierCreate.getIdProprietaire());
            }
            Panier panier = result.get(0);
            if (!Objects.equals(panier.getNomsFestivaliers(), panierCreate.getNomsFestivaliers())) {
                throw new NotFoundException(PANIER, "nomsFestivaliers", panierCreate.getNomsFestivaliers());
            }
            return panierMapper.entityToDTO(panier);
        }
        return null;
    }

    // DELETE
    public void deleteById(Long id) {
        panierRepository.deleteById(id);
    }

    public void delete(Panier panier) {
        panierRepository.delete(panier);
    }
}
