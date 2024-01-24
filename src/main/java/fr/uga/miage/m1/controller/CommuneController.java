package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.service.CommuneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @Autowired
    private CommuneMapper communeMapper;

    @PostMapping("/commune")
    @Operation(summary = "Create a new commune")
    public void createCommune(@RequestBody CommuneDTO communeDTO) {
        Commune commune = communeMapper.dtoToEntity(communeDTO);
        communeService.save(commune);
    }

    @GetMapping("/commune/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get commune by ID")
    public CommuneDTO getCommuneById(@PathVariable Long id) {
        Commune commune = communeService.getById(id);
        return communeMapper.entityToDTO(commune);

    }

    @GetMapping("/commune/nom/{nom}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get commune by name")
    public CommuneDTO getCommuneByNom(@PathVariable String nom) {
        Commune commune = communeService.getByNom(nom);
        return communeMapper.entityToDTO(commune);
    }

    @GetMapping("/commune/code_postal/{codePostal}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get communes by postal code")
    public List<CommuneDTO> getCommunesByCodePostal(@PathVariable String codePostal) {
        List<Commune> communes = communeService.getByCodePostal(codePostal);
        return communeMapper.entityToDTO(communes);
    }

    @GetMapping("/communes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Communes found"),
            @ApiResponse(responseCode = "204", description = "No communes found")
    })
    @Operation(summary = "Get all communes")
    public List<CommuneDTO> getAllCommunes() {
        List<Commune> communes = communeService.getAllCommunes();
        return communeMapper.entityToDTO(communes);
    }

    @DeleteMapping("/commune/{id}")
    @Operation(summary = "Delete commune by ID")
    public void deleteCommuneById(@PathVariable Long id) {
        communeService.deleteById(id);
    }
}
