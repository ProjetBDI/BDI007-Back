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

    @GetMapping("departement/nom/{nomDepartement}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departement found"),
            @ApiResponse(responseCode = "204", description = "Departement not found")
    })
    @Operation(summary = "Get departement by name")
    public DepartementDTO getDepartementByNom(@PathVariable String nomDepartement) {
        Departement departement = departementService.getByNom(nomDepartement);
        return departementMapper.entityToDTO(departement);
    }

    @GetMapping("departement/num/{numDepartement}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departement found"),
            @ApiResponse(responseCode = "204", description = "Departement not found")
    })
    @Operation(summary = "Get departement by number")
    public DepartementDTO getDepartementByNum(@PathVariable String numDepartement) {
        Departement departement = departementService.getByNumDepartement(numDepartement);
        return departementMapper.entityToDTO(departement);
    }

    @GetMapping("departements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Departements found"),
            @ApiResponse(responseCode = "204", description = "No departements found")
    })
    @Operation(summary = "Get all departements")
    public List<DepartementDTO> getAllDepartements() {
        List<Departement> departements = departementService.getAllDepartements();
        return departementMapper.entityToDTO(departements);
    }

    @DeleteMapping("departement/{id}")
    @Operation(summary = "Delete departement by ID")
    public void deleteDepartementById(@PathVariable Long id) {
        departementService.deleteById(id);
    }
}
