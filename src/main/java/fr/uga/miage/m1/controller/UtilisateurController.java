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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @PostMapping("/utilisateur")
    @Operation(summary = "Create a new utilisateur")
    public void createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.dtoToEntity(utilisateurDTO);
        utilisateurService.save(utilisateur);
    }

    @GetMapping("utilisateur/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur found"),
            @ApiResponse(responseCode = "204", description = "Utilisateur not found")
    })
    @Operation(summary = "Get utilisateur by ID")
    public UtilisateurDTO getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurService.getById(id);
        return utilisateurMapper.entityToDTO(utilisateur);
    }

    @GetMapping("utilisateurs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateurs found"),
            @ApiResponse(responseCode = "204", description = "No utilisateurs found")
    })
    @Operation(summary = "Get all utilisateurs")
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUsers();
        return utilisateurs.stream()
                .map(utilisateurMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("utilisateur/email/{email}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utilisateur found"),
            @ApiResponse(responseCode = "204", description = "Utilisateur not found")
    })
    @Operation(summary = "Get utilisateur by email")
    public UtilisateurDTO getUtilisateurByEmail(@PathVariable String email) {
        Utilisateur utilisateur = utilisateurService.getByEmail(email);
        return utilisateurMapper.entityToDTO(utilisateur);
    }

    @DeleteMapping("utilisateur/{id}")
    @Operation(summary = "Delete utilisateur by ID")
    public void deleteUtilisateurById(@PathVariable Long id) {
        utilisateurService.deleteById(id);
    }
}
