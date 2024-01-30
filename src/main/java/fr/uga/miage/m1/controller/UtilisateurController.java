package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.service.UtilisateurService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "Festivals not found")
    })
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {
        List<UtilisateurDTO> utilisateurDTOList = utilisateurService.findAll();
        if (utilisateurDTOList.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(utilisateurDTOList);
    }

<<<<<<< HEAD
=======
    @GetMapping("/utilisateur/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs found"),
            @ApiResponse(responseCode = "204", description = "Utilisateurs not found")
    })
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable Long id) {
        UtilisateurDTO utilisateurDTO = utilisateurService.getById(id);
        if (utilisateurDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(utilisateurDTO);
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

>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734
}
