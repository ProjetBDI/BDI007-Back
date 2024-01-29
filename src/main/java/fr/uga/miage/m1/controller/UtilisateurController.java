package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.service.UtilisateurService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "Festivals not found")
    })
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurService.findAll();
    }

    @GetMapping("/utilisateur/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs found"),
            @ApiResponse(responseCode = "204", description = "Utilisateurs not found")
    })
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getById(id);
    }

    @GetMapping("/utilisateur/email/{email}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs found"),
            @ApiResponse(responseCode = "204", description = "Utilisateurs not found")
    })
    public ResponseEntity<UtilisateurDTO> getUtilisateurByEmail(@PathVariable String email) {
        UtilisateurDTO utilisateurDTO = utilisateurService.getByEmail(email);
        if (utilisateurDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(utilisateurDTO);

    }

}
