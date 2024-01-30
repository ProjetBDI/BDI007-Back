package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.error.NotFoundException;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import fr.uga.miage.m1.repository.UtilisateurRepository;
=======
import java.util.List;
>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    @PersistenceContext
    private EntityManager entityManager;
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

<<<<<<< HEAD
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
=======

>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734
    // SAVE
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // GET
    public List<UtilisateurDTO> findAll() {
        return utilisateurMapper.entityToDTO(utilisateurRepository.findAll());
    }

    public UtilisateurDTO getById(Long id) {
        return utilisateurMapper.entityToDTO(utilisateurRepository.findById(id).orElse(null));
    }

<<<<<<< HEAD
=======
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


>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734
    // DELETE
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }
}