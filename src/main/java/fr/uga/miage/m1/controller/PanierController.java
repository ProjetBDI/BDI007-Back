package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.controller.create.PanierCreate;
import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.service.PanierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Log
public class PanierController {

    private final PanierService panierService;

    @PostMapping("/panier")
    @Operation(summary = "Create a new panier")
    public void createPanier(@RequestBody PanierDTO panierDTO) {
        panierService.save(panierDTO);
    }

    @GetMapping("panier/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier found"),
            @ApiResponse(responseCode = "204", description = "Panier not found")
    })
    @Operation(summary = "Get panier by ID")
    public ResponseEntity<PanierDTO> getPanierById(@PathVariable Long id) {
        PanierDTO panier = panierService.getById(id);
        if (panier == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(panier);
    }


    @GetMapping("panier/utilisateur/current/{idUtilisateur}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier found"),
            @ApiResponse(responseCode = "204", description = "Panier not found")
    })
    @Operation(summary = "Get current panier for an user")
    public ResponseEntity<PanierDTO> getCurrentPanierByUtilisateurId(@PathVariable Long idUtilisateur) {
        PanierDTO panierDTO = panierService.getCurrentPanierByUtilisateurId(idUtilisateur);
        if (panierDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(panierDTO);
    }

    @PostMapping("panier/payer/{idPanier}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande payée"),
            @ApiResponse(responseCode = "204", description = "Paiement impossible")
    })
    @Operation(summary = "Payer une commande")
    public ResponseEntity<PanierDTO> postPayer(@PathVariable Long idPanier) throws IOException {
        PanierDTO panierDTO = panierService.postPayer(idPanier);
        if (panierDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        log.info("PanierDTO payé: " + panierDTO);
        return ResponseEntity.status(200).body(panierDTO);
    }

    @PostMapping("panier/create")
    @Operation(summary = "Create a new panier")
    public ResponseEntity<PanierDTO> createPanier(@RequestBody PanierCreate panierCreate) {
        log.info("Panier received: " + panierCreate.toString());
        PanierDTO panier = panierService.saveCustom(panierCreate);
        log.info("Panier createdController: " + panier.toString());
        if (panier == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(panier);
    }


    @DeleteMapping("panier/{id}")
    @Operation(summary = "Delete panier by ID")
    public void deletePanierById(@PathVariable Long id) {
        panierService.deleteById(id);
    }
}