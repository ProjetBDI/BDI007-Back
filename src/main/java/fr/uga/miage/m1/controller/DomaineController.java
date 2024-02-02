package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.service.DomaineService;
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
public class DomaineController {

    private final DomaineService domaineService;

    @PostMapping("/domaine")
    @Operation(summary = "Create a new domaine")
    public ResponseEntity<DomaineDTO> createDomaine(@RequestBody DomaineDTO domaineDTO) {
        DomaineDTO savedDomaine = domaineService.save(domaineDTO);
        if (savedDomaine == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(savedDomaine);
    }

    @GetMapping("domaine/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domaine found"),
            @ApiResponse(responseCode = "204", description = "Domaine not found")
    })
    @Operation(summary = "Get domaine by ID")
    public ResponseEntity<DomaineDTO> getDomaineById(@PathVariable Long id) {
        DomaineDTO domaine = domaineService.getById(id);
        if (domaine == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(domaine);
    }


    @GetMapping("domaines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domaines found"),
            @ApiResponse(responseCode = "204", description = "No domaines found")
    })
    @Operation(summary = "Get all domaines")
    public ResponseEntity<List<DomaineDTO>> getAllDomaines() {
        List<DomaineDTO> domaines = domaineService.getAllDomaines();
        if (domaines.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(domaines);
    }

    @DeleteMapping("domaine/{id}")
    @Operation(summary = "Delete domaine by ID")
    public void deleteDomaineById(@PathVariable Long id) {
        domaineService.delete(id);
    }
}
