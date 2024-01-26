package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.service.CommuneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @GetMapping("commune/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get by ID")
    public CommuneDTO getCommuneById(@PathVariable Long id) {
        return communeService.getById(id);
    }

    @GetMapping("communes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get all communes")
    public List<CommuneDTO> getCommunes() {
        return communeService.getAllCommunes();
    }

    @GetMapping("commune/nom/{nom}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get commune by name")
    public List<CommuneDTO> getCommuneByNom(@PathVariable String nom) {
        return communeService.getByNom(nom);
    }
}