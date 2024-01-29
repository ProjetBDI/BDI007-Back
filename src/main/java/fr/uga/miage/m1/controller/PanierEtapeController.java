package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.service.PanierEtapeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PanierEtapeController {

    private final PanierEtapeService panierEtapeService;

    @PostMapping("/panierEtape")
    @Operation(summary = "Create a new panier etape")
    public ResponseEntity<PanierEtapeDTO> createPanierEtape(@RequestBody PanierEtapeDTO panierEtapeDTO) {
        PanierEtapeDTO panierEtape = panierEtapeService.save(panierEtapeDTO);
        if (panierEtape == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(panierEtape);
    }

    @GetMapping("panierEtape/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier etape found"),
            @ApiResponse(responseCode = "204", description = "Panier etape not found")
    })
    @Operation(summary = "Get panier etape by ID")
    public ResponseEntity<PanierEtapeDTO> getPanierEtapeById(@PathVariable Long id) {
        PanierEtapeDTO panierEtape = panierEtapeService.getById(id);
        if (panierEtape == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(panierEtape);
    }

    @GetMapping("panierEtapes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paniers found"),
            @ApiResponse(responseCode = "204", description = "No paniers found")
    })
    @Operation(summary = "Get all paniers")
    public ResponseEntity<List<PanierEtapeDTO>> getAllPaniers() {
        List<PanierEtapeDTO> panierEtapes = panierEtapeService.getAllPanierEtapes();
        if (panierEtapes.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(panierEtapes);
    }

    @DeleteMapping("panierEtape/{id}")
    @Operation(summary = "Delete panier etape by ID")
    public void deletePanierEtapeById(@PathVariable Long id) {
        panierEtapeService.deleteById(id);
    }
}
