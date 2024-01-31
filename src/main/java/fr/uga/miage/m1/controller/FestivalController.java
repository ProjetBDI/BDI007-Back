package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.EtapeDTO;
import fr.uga.miage.m1.dto.FestivalDTO;
import fr.uga.miage.m1.service.FestivalService;
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
public class FestivalController {

    private final FestivalService festivalService;


    @GetMapping("festival/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festival found"),
            @ApiResponse(responseCode = "204", description = "Festival not found")
    })
    @Operation(summary = "Get festival by ID")
    public ResponseEntity<FestivalDTO> getFestivalById(@PathVariable Long id) {
        FestivalDTO festival = festivalService.getById(id);
        if (festival == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(festival);
    }

    @GetMapping("festivals/page/{number}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "Festivals not found")
    })
    @Operation(summary = "Get all festivals by pages")
    public ResponseEntity<List<FestivalDTO>> getAllFestivalsUsingPages(@PathVariable int number) {
        List<FestivalDTO> festivals = festivalService.getAllFestivalsUsingPages(number);
        if (festivals == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(festivals);
    }

    @GetMapping("festivals/page/{number}/name/{name}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Festivals found"),
            @ApiResponse(responseCode = "204", description = "Festivals not found")
    })
    @Operation(summary = "Get all festivals by pages")
    public ResponseEntity<List<FestivalDTO>> getFestivalsByNameUsingPages(@PathVariable String name, @PathVariable int number) {
        List<FestivalDTO> festivals = festivalService.getAllFestivalsByNameUsingPages(name, number);
        if (festivals == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(festivals);
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
