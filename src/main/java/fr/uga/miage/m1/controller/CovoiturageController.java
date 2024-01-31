package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.service.CovoiturageService;
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
public class CovoiturageController {

    private final CovoiturageService covoiturageService;


    @PostMapping("/covoiturage") // Change the mapping path
    @Operation(summary = "Create a new covoiturage")
    public void createCovoiturage(@RequestBody CovoiturageDTO covoiturageDTO) {
        covoiturageService.save(covoiturageDTO);
    }


    @GetMapping("covoiturages/page/{number}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturages found"),
            @ApiResponse(responseCode = "204", description = "Covoiturages not found")
    })
    @Operation(summary = "Get all covoiturages by pages")
    public ResponseEntity<List<CovoiturageDTO>> getCovoituragesByPages(@PathVariable int number) {
        List<CovoiturageDTO> covoiturages = covoiturageService.getAllCovoituragesUsingPages(number);
        if (covoiturages.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(covoiturages);
    }

    @GetMapping("covoiturage/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturage found"),
            @ApiResponse(responseCode = "204", description = "Covoiturage not found")
    })
    @Operation(summary = "Get covoiturage by ID")
    public ResponseEntity<CovoiturageDTO> getCovoiturageById(@PathVariable Long id) {
        CovoiturageDTO covoiturageDTO = covoiturageService.getById(id);
        if (covoiturageDTO == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(covoiturageDTO);
    }

    @GetMapping("covoiturages/page/{number}/festival/{idFestival}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturages found"),
            @ApiResponse(responseCode = "204", description = "Covoiturages not found")
    })
    @Operation(summary = "Get all covoiturages by pages")
    public ResponseEntity<List<CovoiturageDTO>> getCovoituragesByPages(@PathVariable int number, @PathVariable Long idFestival) {
        List<CovoiturageDTO> covoiturages = covoiturageService.getAllCovoituragesByFestivalUsingPages(number, idFestival);
        if (covoiturages.isEmpty()) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(covoiturages);
    }


    @DeleteMapping("covoiturage/{id}") // Change the mapping path
    @Operation(summary = "Delete covoiturage by ID")
    public void deleteCovoiturageById(@PathVariable Long id) {
        covoiturageService.deleteById(id);
    }
}
