package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CommuneDTO;
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

    @GetMapping("festival/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival found"),
            @ApiResponse(responseCode = "204", description = "Festival not found")
    })
    @Operation(summary = "Get festival by ID")
    public FestivalDTO getFestivalById(@PathVariable Long id) {
        return festivalService.getById(id);
    }

    @GetMapping("festivals/page/{number}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get all festivals by pages")
    public List<FestivalDTO> getFestivalsByPages(@PathVariable int number) {
        return festivalService.getAllFestivalsByPages(number);
    }

    @DeleteMapping("festival/{id}")
    @GetMapping("festival/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival found"),
            @ApiResponse(responseCode = "204", description = "Festival not found")
    })
    @Operation(summary = "Delete festival by ID")
    public void deleteFestivalById(@PathVariable Long id) {
        festivalService.deleteById(id);
    }
}
