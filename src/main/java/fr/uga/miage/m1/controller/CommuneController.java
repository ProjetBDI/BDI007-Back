package fr.uga.miage.m1.controller;


import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.service.CommuneService;
import io.swagger.v3.oas.annotations.Operation;
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
public class CommuneController {

    private final CommuneService communeService;

    @GetMapping("commune/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get by ID")
    public ResponseEntity<CommuneDTO> getCommuneById(@PathVariable Long id) {
        CommuneDTO communeDTO = communeService.getById(id);
        if (communeDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(communeDTO);
    }

    @GetMapping("communes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get all communes")
    public ResponseEntity<List<CommuneDTO>> getCommunes() {
        List<CommuneDTO> communeDTOList = communeService.getAllCommunes();
        if (communeDTOList.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(communeDTOList);
    }

    @GetMapping("commune/nom/{nom}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get commune by name")
    public ResponseEntity<List<CommuneDTO>> getCommuneByNom(@PathVariable String nom) {
        List<CommuneDTO> communeDTOList = communeService.getByNom(nom);
        if (communeDTOList.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(communeDTOList);
    }

}