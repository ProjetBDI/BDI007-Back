package fr.uga.miage.m1.controller;
import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.mapper.UtilisateurMapper;
import fr.uga.miage.m1.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @GetMapping("/{id}")
    public UtilisateurDTO getUtilisateurById(Long id) {
        return utilisateurMapper.entityToDTO(utilisateurService.getById(id));
    }

}
