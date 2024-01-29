package fr.uga.miage.m1.service;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;


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


    // DELETE
    public void deleteById(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurRepository.delete(utilisateur);
    }
}
