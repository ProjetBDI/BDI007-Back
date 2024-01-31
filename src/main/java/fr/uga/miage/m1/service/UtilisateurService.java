package fr.uga.miage.m1.service;

import fr.uga.miage.m1.controller.create.UtilisateurCreate;
import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log
public class UtilisateurService {

    @PersistenceContext
    private EntityManager entityManager;
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;


    // GET
    public List<UtilisateurDTO> findAll() {
        return utilisateurMapper.entityToDTO(utilisateurRepository.findAll());
    }

    public UtilisateurDTO getById(Long id) {
        return utilisateurMapper.entityToDTO(utilisateurRepository.findById(id).orElse(null));
    }

    public UtilisateurDTO getByEmail(String email) {
        TypedQuery<Utilisateur> query = entityManager.createQuery("From Utilisateur u where u.email = :email ", Utilisateur.class);
        query.setParameter("email", email);
        List<Utilisateur> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        if (result.size() > 1) {
            throw new NotFoundException("Utilisateur", "email", email);
        }
        return utilisateurMapper.entityToDTO(result.get(0));
    }

    @Transactional
    public UtilisateurDTO saveCustom(UtilisateurCreate utilisateurCreate) {
        TypedQuery<Void> query = entityManager.createQuery("INSERT INTO utilisateur (id_utilisateur, email, nom, prenom, mot_de_passe, date_naissance, telephone) VALUES (utilisateur_id_sequence.nextval ,:email, :nom, :prenom, :mot_de_passe, :date_naissance, :telephone)", Void.class);
        query.setParameter("email", utilisateurCreate.getEmail());
        query.setParameter("nom", utilisateurCreate.getNom());
        query.setParameter("prenom", utilisateurCreate.getPrenom());
        query.setParameter("mot_de_passe", utilisateurCreate.getMotDePasse());
        query.setParameter("date_naissance", utilisateurCreate.getDateNaissance());
        query.setParameter("telephone", utilisateurCreate.getTelephone());
        int res = query.executeUpdate();
        log.info("Utilisateur created: " + utilisateurCreate);
        if (res == 1) {
            // find last insert
            TypedQuery<Utilisateur> querySelect = entityManager.createQuery("From Utilisateur ORDER BY idUtilisateur DESC LIMIT 1", Utilisateur.class);
            List<Utilisateur> result = querySelect.getResultList();
            if (result.isEmpty()) {
                return null;
            }
            if (result.size() > 1) {
                throw new NotFoundException("Utilisateur", "email", utilisateurCreate.getEmail());
            }
            Utilisateur utilisateur = result.get(0);
            if (!Objects.equals(utilisateur.getEmail(), utilisateurCreate.getEmail())) {
                throw new NotFoundException("Utilisateur", "email", utilisateurCreate.getEmail());
            }
            return utilisateurMapper.entityToDTO(utilisateur);
        }
        return null;
    }

    // DELETE
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }
}