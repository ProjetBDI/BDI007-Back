package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.service.EtapeService;
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
public class EtapeController {

    private final EtapeService etapeService;

    @PostMapping("etape")
    @Operation(summary = "Create a new etape")
    public ResponseEntity<EtapeDTO> createEtape(@RequestBody EtapeDTO etapeDTO) {
        EtapeDTO savedEtape = etapeService.save(etapeDTO);
        if (savedEtape == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(savedEtape);
    }

    @GetMapping("etape/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Etape found"),
            @ApiResponse(responseCode = "204", description = "Etape not found")
    })
    @Operation(summary = "Get etape by ID")
    public ResponseEntity<EtapeDTO> getEtapeById(@PathVariable Long id) {
        EtapeDTO etape = etapeService.getById(id);
        if (etape == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(etape);
    }

    @GetMapping("festival/{idFestival}/covoiturage/etapes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival found"),
            @ApiResponse(responseCode = "204", description = "Festival not found")
    })
    @Operation(summary = "Get etapes for festival by ID")
    public ResponseEntity<List<EtapeDTO>> getEtapesForFestivalById(@PathVariable Long idFestival) {
        List<EtapeDTO> etapesDTO = etapeService.getEtapesForFestivalById(idFestival);
        if (etapesDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(etapesDTO);
    }

    @DeleteMapping("etape/{id}")
    @Operation(summary = "Delete etape by ID")
    public void deleteEtapeById(@PathVariable Long id) {
        etapeService.deleteById(id);
    }
}
