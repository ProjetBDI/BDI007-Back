package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.service.UtilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @GetMapping("/utilisateurss/")
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurService.getById(id);
    }

//    @GetMapping("/utilisateur/{id}")
//    public UtilisateurDTO getUtilisateurById(Long id) {
//        return utilisateurMapper.entityToDTO(utilisateurService.getById(id));
//    }

//    @GetMapping("/utilisates")
//    public Iterable<Utilisateur> getUtilisateurs() {
//        return utilisateurService.getAllUsers();
//    }





//    @GetMapping("/utilisateurs")
//    public Collection<UtilisateurDTO> getUtilisateurs() {
//        Collection<Utilisateur> utilisateurs = (utilisateurService.getAllUsers());
//        List<UtilisateurDTO> user = utilisateurs.stream().map(utilisateurMapper::entityToDTO).toList();
//        System.out.println(user.get(0));
//        return user;
//    }

}
