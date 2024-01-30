package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.service.DepartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DepartementController {

    private final DepartementService departementService;

    @PostMapping("/departement")
    @Operation(summary = "Create a new departement")
    public void createDepartement(@RequestBody DepartementDTO departementDTO) {
        departementService.save(departementDTO);
    }

    @GetMapping("departement/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departement found"),
            @ApiResponse(responseCode = "204", description = "Departement not found")
    })
    @Operation(summary = "Get departement by ID")
    public ResponseEntity<DepartementDTO> getDepartementById(@PathVariable Long id) {
        DepartementDTO departement = departementService.getById(id);
        if (departement == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(departement);
    }


    @DeleteMapping("departement/{id}")
    @Operation(summary = "Delete departement by ID")
    public void deleteDepartementById(@PathVariable Long id) {
        departementService.deleteById(id);
    }
}
