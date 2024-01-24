package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @GetMapping("/utilisateur/{id}")
    public UtilisateurDTO getUtilisateurById(Long id) {
        return utilisateurMapper.entityToDTO(utilisateurService.getById(id));
    }

    @GetMapping("/utilisateurs")
    public Collection<UtilisateurDTO> getUtilisateurs() {
        Collection<Utilisateur> utilisateurs = (utilisateurService.getAllUsers());
        System.out.println(utilisateurs);
        return utilisateurs.stream().map(utilisateurMapper::entityToDTO).toList();
    }

}
