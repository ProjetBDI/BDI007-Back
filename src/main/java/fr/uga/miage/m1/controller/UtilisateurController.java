package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.controller.create.UtilisateurCreate;
import fr.uga.miage.m1.dto.UtilisateurDTO;
import fr.uga.miage.m1.service.UtilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Log
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
        log.info("Utilisateur foundController: " + utilisateurDTO.toString());
        if (utilisateurDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(utilisateurDTO);

    }

    @PostMapping("/utilisateur/create")
    @Operation(summary = "Create utilisateur")
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurCreate utilisateurCreate) {
        UtilisateurDTO utilisateur = utilisateurService.saveCustom(utilisateurCreate);
        log.info("Utilisateur createdController: " + utilisateur.toString());
        if (utilisateur == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(utilisateur);
    }

    @DeleteMapping("/utilisateur/{id}")
    @Operation(summary = "Delete utilisateur by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs found"),
            @ApiResponse(responseCode = "204", description = "Utilisateurs not found")
    })
    public void deleteUtilisateurById(@PathVariable Long id) {
        utilisateurService.deleteById(id);
    }

}
