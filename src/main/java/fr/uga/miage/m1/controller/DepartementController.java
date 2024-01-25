package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.mapper.DepartementMapper;
import fr.uga.miage.m1.model.Departement;
import fr.uga.miage.m1.service.DepartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @Autowired
    private DepartementMapper departementMapper;

    @PostMapping("/departement")
    @Operation(summary = "Create a new departement")
    public void createDepartement(@RequestBody DepartementDTO departementDTO) {
        Departement departement = departementMapper.dtoToEntity(departementDTO);
        departementService.save(departement);
    }

    @GetMapping("departement/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departement found"),
            @ApiResponse(responseCode = "204", description = "Departement not found")
    })
    @Operation(summary = "Get departement by ID")
    public DepartementDTO getDepartementById(@PathVariable Long id) {
        Departement departement = departementService.getById(id);
        return departementMapper.entityToDTO(departement);
    }







    @DeleteMapping("departement/{id}")
    @Operation(summary = "Delete departement by ID")
    public void deleteDepartementById(@PathVariable Long id) {
        departementService.deleteById(id);
    }
}
