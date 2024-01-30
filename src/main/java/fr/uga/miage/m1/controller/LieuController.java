package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.LieuDTO;
<<<<<<< HEAD
import fr.uga.miage.m1.mapper.LieuMapper;
import fr.uga.miage.m1.model.Lieu;
=======
>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734
import fr.uga.miage.m1.service.LieuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD

=======
>>>>>>> 34342eb29f91494e13d2592fe640b7a5eb6de734
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class LieuController {


    private final LieuService lieuService;


    @PostMapping("lieu")
    @Operation(summary = "Create a new lieu")
    public ResponseEntity<LieuDTO> createLieu(@RequestBody LieuDTO lieuDTO) {
        LieuDTO lieu = lieuService.save(lieuDTO);
        if (lieu == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(201).body(lieu);
    }

    @GetMapping("lieu/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lieu found"),
            @ApiResponse(responseCode = "204", description = "Lieu not found")
    })
    @Operation(summary = "Get lieu by ID")
    public ResponseEntity<LieuDTO> getLieuById(@PathVariable Long id) {
        LieuDTO lieu = lieuService.getById(id);
        if (lieu == null) {
            return ResponseEntity.status(204).body(null);
        }
        return ResponseEntity.status(200).body(lieu);
    }


    @DeleteMapping("lieu/{id}")
    @Operation(summary = "Delete lieu by ID")
    public void deleteLieuById(@PathVariable Long id) {
        lieuService.deleteById(id);
    }


}
