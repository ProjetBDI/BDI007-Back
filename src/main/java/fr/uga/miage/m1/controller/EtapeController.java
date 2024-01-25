package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.mapper.EtapeMapper;
import fr.uga.miage.m1.model.Etape;
import fr.uga.miage.m1.service.EtapeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class EtapeController {

    @Autowired
    private EtapeService etapeService;

    @Autowired
    private EtapeMapper etapeMapper;

    @PostMapping("/etape")
    @Operation(summary = "Create a new etape")
    public EtapeDTO createEtape(@RequestBody EtapeDTO etapeDTO) {
        Etape etape = etapeMapper.dtoToEntity(etapeDTO);
        Etape savedEtape = etapeService.save(etape);
        return etapeMapper.entityToDTO(savedEtape);
    }

    @GetMapping("etape/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Etape found"),
            @ApiResponse(responseCode = "204", description = "Etape not found")
    })
    @Operation(summary = "Get etape by ID")
    public EtapeDTO getEtapeById(@PathVariable Long id) {
        Etape etape = etapeService.getById(id);
        return etapeMapper.entityToDTO(etape);
    }





    @DeleteMapping("etape/{id}")
    @Operation(summary = "Delete etape by ID")
    public void deleteEtapeById(@PathVariable Long id) {
        etapeService.deleteById(id);
    }
}
