package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/utilisateurs/")
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

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
