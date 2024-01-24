package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.dto.LieuDTO;
import fr.uga.miage.m1.mapper.LieuMapper;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.model.Lieu;
import fr.uga.miage.m1.service.LieuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LieuController {

    @Autowired
    private LieuService lieuService;

    @Autowired
    private LieuMapper lieuMapper;

    @PostMapping("/lieu")
    @Operation(summary = "Create a new lieu")
    public void createLieu(@RequestBody LieuDTO lieuDTO) {
        Lieu lieu = lieuMapper.dtoToEntity(lieuDTO);
        lieuService.save(lieu);
    }

    @GetMapping("lieu/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lieu found"),
            @ApiResponse(responseCode = "204", description = "Lieu not found")
    })
    @Operation(summary = "Get lieu by ID")
    public LieuDTO getLieuById(@PathVariable Long id) {
        Lieu lieu = lieuService.getById(id);
        return lieuMapper.entityToDTO(lieu);
    }

    @GetMapping("lieu/type/{typeLieu}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lieu found"),
            @ApiResponse(responseCode = "204", description = "Lieu not found")
    })
    @Operation(summary = "Get lieu by type")
    public LieuDTO getLieuByType(@PathVariable String typeLieu) {
        Lieu lieu = lieuService.getByTypeLieu(typeLieu);
        return lieuMapper.entityToDTO(lieu);
    }

    @DeleteMapping("lieu/{id}")
    @Operation(summary = "Delete lieu by ID")
    public void deleteLieuById(@PathVariable Long id) {
        lieuService.deleteById(id);
    }

    @GetMapping("lieux")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lieu found"),
            @ApiResponse(responseCode = "204", description = "No Lieu found")
    })
    @Operation(summary = "Get all lieux")
    public List<LieuDTO> getAllLieux() {
        List<Lieu> lieux = lieuService.getAllLieux();
        return lieux.stream()
                .map(lieuMapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
