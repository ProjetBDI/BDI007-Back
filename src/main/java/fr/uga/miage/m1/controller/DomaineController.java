package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.DomaineDTO;
import fr.uga.miage.m1.mapper.DomaineMapper;
import fr.uga.miage.m1.model.Domaine;
import fr.uga.miage.m1.service.DomaineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DomaineController {

    @Autowired
    private DomaineService domaineService;

    @Autowired
    private DomaineMapper domaineMapper;

    @PostMapping("/domaine")
    @Operation(summary = "Create a new domaine")
    public DomaineDTO createDomaine(@RequestBody DomaineDTO domaineDTO) {
        Domaine domaine = domaineMapper.dtoToEntity(domaineDTO);
        Domaine savedDomaine = domaineService.save(domaine);
        return domaineMapper.entityToDTO(savedDomaine);
    }

    @GetMapping("domaine/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domaine found"),
            @ApiResponse(responseCode = "204", description = "Domaine not found")
    })
    @Operation(summary = "Get domaine by ID")
    public DomaineDTO getDomaineById(@PathVariable Long id) {
        Domaine domaine = domaineService.getById(id);
        return domaineMapper.entityToDTO(domaine);
    }


    @GetMapping("domaines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Domaines found"),
            @ApiResponse(responseCode = "204", description = "No domaines found")
    })
    @Operation(summary = "Get all domaines")
    public Iterable<Domaine> getAllDomaines() {
        Iterable<Domaine> domaines = domaineService.getAllDomaines();
        return domaines;
    }

    @DeleteMapping("domaine/{id}")
    @Operation(summary = "Delete domaine by ID")
    public void deleteDomaineById(@PathVariable Long id) {
        domaineService.delete(id);
    }
}
