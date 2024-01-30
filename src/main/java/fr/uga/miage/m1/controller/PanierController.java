package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.PanierDTO;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.model.Panier;
import fr.uga.miage.m1.service.PanierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class PanierController {

    @Autowired
    private PanierService panierService;

    @Autowired
    private PanierMapper panierMapper;

    @PostMapping("/panier")
    @Operation(summary = "Create a new panier")
    public void createPanier(@RequestBody PanierDTO panierDTO) {
        Panier panier = panierMapper.dtoToEntity(panierDTO);
        panierService.save(panier);
    }

    @GetMapping("panier/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Panier found"),
            @ApiResponse(responseCode = "204", description = "Panier not found")
    })
    @Operation(summary = "Get panier by ID")
    public PanierDTO getPanierById(@PathVariable Long id) {
        Panier panier = panierService.getById(id);
        return panierMapper.entityToDTO(panier);
    }



    @DeleteMapping("panier/{id}")
    @Operation(summary = "Delete panier by ID")
    public void deletePanierById(@PathVariable Long id) {
        panierService.deleteById(id);
    }
}
