package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.PanierEtapeDTO;
import fr.uga.miage.m1.mapper.PanierEtapeMapper;
import fr.uga.miage.m1.model.PanierEtape;
import fr.uga.miage.m1.service.PanierEtapeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class PanierEtapeController {

    @Autowired
    private PanierEtapeService panierEtapeService;

    @Autowired
    private PanierEtapeMapper panierEtapeMapper;

    @PostMapping("/panierEtape")
    @Operation(summary = "Create a new panier etape")
    public void createPanierEtape(@RequestBody PanierEtapeDTO panierEtapeDTO) {
        PanierEtape panierEtape = panierEtapeMapper.dtoToEntity(panierEtapeDTO);
        panierEtapeService.save(panierEtape);
    }

    @GetMapping("panierEtape/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier etape found"),
            @ApiResponse(responseCode = "204", description = "Panier etape not found")
    })
    @Operation(summary = "Get panier etape by ID")
    public PanierEtapeDTO getPanierEtapeById(@PathVariable Long id) {
        PanierEtape panierEtape = panierEtapeService.getById(id);
        return panierEtapeMapper.entityToDTO(panierEtape);
    }

    @GetMapping("panierEtapes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paniers found"),
            @ApiResponse(responseCode = "204", description = "No paniers found")
    })
    @Operation(summary = "Get all paniers")
    public List<PanierEtapeDTO> getAllPaniers() {
        List<PanierEtape> paniers = panierEtapeService.getAllPaniers();
        return panierEtapeMapper.entityToDTO(paniers);
    }

    @DeleteMapping("panierEtape/{id}")
    @Operation(summary = "Delete panier etape by ID")
    public void deletePanierEtapeById(@PathVariable Long id) {
        panierEtapeService.deleteById(id);
    }
}
