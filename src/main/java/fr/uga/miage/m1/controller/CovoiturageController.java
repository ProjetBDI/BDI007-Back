package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CovoiturageDTO;
import fr.uga.miage.m1.mapper.CovoiturageMapper;
import fr.uga.miage.m1.model.Covoiturage;
import fr.uga.miage.m1.service.CovoiturageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1") // Change the mapping path
public class CovoiturageController {

    @Autowired
    private CovoiturageService covoiturageService;

    @Autowired
    private CovoiturageMapper covoiturageMapper;

    @PostMapping("/covoiturage") // Change the mapping path
    @Operation(summary = "Create a new covoiturage")
    public void createCovoiturage(@RequestBody CovoiturageDTO covoiturageDTO) {
        Covoiturage covoiturage = covoiturageMapper.dtoToEntity(covoiturageDTO);
        covoiturageService.save(covoiturage);
    }

//    @GetMapping("covoiturage/{id}") // Change the mapping path
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Covoiturage found"),
//            @ApiResponse(responseCode = "204", description = "Covoiturage not found")
//    })
//    @Operation(summary = "Get covoiturage by ID")
//    public CovoiturageDTO getCovoiturageById(@PathVariable Long id) {
//        Covoiturage covoiturage = covoiturageService.getById(id);
//        return covoiturageMapper.entityToDTO(covoiturage);
//    }

    @GetMapping("covoiturages/page/{number}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturages found"),
            @ApiResponse(responseCode = "204", description = "Covoiturages not found")
    })
    @Operation(summary = "Get all covoiturages by pages")
    public List<CovoiturageDTO> getCovoituragesByPages(@PathVariable int number) {
        return covoiturageService.getAllCovoituragesByPages(number);
    }

    @GetMapping("covoiturages/page/{number}/festival/{idFestival}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Covoiturages found"),
            @ApiResponse(responseCode = "204", description = "Covoiturages not found")
    })
    @Operation(summary = "Get all covoiturages by pages")
    public List<CovoiturageDTO> getCovoituragesByPages(@PathVariable int number, @PathVariable Long idFestival) {
        return covoiturageService.getAllCovoituragesByFestivalByPages(number, idFestival);
    }


    @DeleteMapping("covoiturage/{id}") // Change the mapping path
    @Operation(summary = "Delete covoiturage by ID")
    public void deleteCovoiturageById(@PathVariable Long id) {
        covoiturageService.deleteById(id);
    }
}
