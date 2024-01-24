package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.model.Festival;
import fr.uga.miage.m1.service.FestivalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class FestivalController {

    @Autowired
    private FestivalService festivalService;

    @Autowired
    private FestivalMapper festivalMapper;

    @PostMapping("/festival")
    @Operation(summary = "Create a new festival")
    public void createFestival(@RequestBody FestivalDTO festivalDTO) {
        Festival festival = festivalMapper.dtoToEntity(festivalDTO);
        festivalService.save(festival);
    }

    @GetMapping("festival/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival found"),
            @ApiResponse(responseCode = "204", description = "Festival not found")
    })
    @Operation(summary = "Get festival by ID")
    public FestivalDTO getFestivalById(@PathVariable Long id) {
        Festival festival = festivalService.getById(id);
        return festivalMapper.entityToDTO(festival);
    }

    @GetMapping("festival/nom/{nom}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "No festivals found")
    })
    @Operation(summary = "Get festivals by name")
    public List<FestivalDTO> getFestivalsByNom(@PathVariable String nom) {
        List<Festival> festivals = festivalService.getByNom(nom);
        return festivals.stream()
                .map(festivalMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("festivals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "No festivals found")
    })
    @Operation(summary = "Get all festivals")
    public List<FestivalDTO> getAllFestivals() {
        List<Festival> festivals = festivalService.getAllFestivals();
        return festivals.stream()
                .map(festivalMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("festival/{id}")
    @Operation(summary = "Delete festival by ID")
    public void deleteFestivalById(@PathVariable Long id) {
        festivalService.deleteById(id);
    }
}
