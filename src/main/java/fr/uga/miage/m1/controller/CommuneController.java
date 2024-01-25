package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.dto.CommuneDTO;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.model.Commune;
import fr.uga.miage.m1.model.Utilisateur;
import fr.uga.miage.m1.service.CommuneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @Autowired
    private CommuneMapper communeMapper;

    @PostMapping("/commune")
    @Operation(summary = "Create a new commune")
    public void createCommune(@RequestBody CommuneDTO communeDTO) {
        Commune commune = communeMapper.dtoToEntity(communeDTO);
        communeService.saveCommune(commune);
    }
    @GetMapping("/communeeee/{id}")
    public CommuneDTO author(@PathVariable Long id) throws Exception {
        try{
            Optional<Commune> commune = this.communeService.getCommune(id);
            return communeMapper.entityToDTO(commune.get());
        }
        catch(Exception e){
            throw e;
        }
    }


    @GetMapping("/communes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found"),
            @ApiResponse(responseCode = "500", description = "Serveur pas trouvé je crois")
    })
    public Iterable<CommuneDTO> communes() {
        return communeMapper.entityToDTO(communeService.getCommunes());
    }


    @GetMapping("/commune")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commune found"),
            @ApiResponse(responseCode = "204", description = "Commune not found")
    })
    @Operation(summary = "Get commune by ID")
    public Commune getCommuneById(@PathVariable Long id) {
        Optional<Commune> communeOptional = communeService.getCommune(id);

        if (communeOptional.isPresent()) {
            return communeOptional.get();
        } else {
            // Gérer le cas où la commune n'est pas trouvée, par exemple, retourner une réponse appropriée.
            // Ici, je retourne null, mais vous pouvez également retourner un objet CommuneDTO vide ou une réponse 404.
            return null;
        }
    }




//    @GetMapping("/commune/nom/{nom}")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Commune found"),
//            @ApiResponse(responseCode = "204", description = "Commune not found")
//    })
//    @Operation(summary = "Get commune by name")
//    public CommuneDTO getCommuneByNom(@PathVariable String nom) {
//        Commune commune = communeService.getByNom(nom);
//        return communeMapper.entityToDTO(commune);
//    }
//
//    @GetMapping("/commune/code_postal/{codePostal}")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Commune found"),
//            @ApiResponse(responseCode = "204", description = "Commune not found")
//    })
//    @Operation(summary = "Get communes by postal code")
//    public List<CommuneDTO> getCommunesByCodePostal(@PathVariable String codePostal) {
//        List<Commune> communes = communeService.getByCodePostal(codePostal);
//        return communeMapper.entityToDTO(communes);
//    }
//
//    @GetMapping("/communes")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Communes found"),
//            @ApiResponse(responseCode = "204", description = "No communes found")
//    })
//    @Operation(summary = "Get all communes")
//    public List<CommuneDTO> getAllCommunes() {
//        List<Commune> communes = communeService.getAllCommunes();
//        return communeMapper.entityToDTO(communes);
//    }
//
//    @DeleteMapping("/commune/{id}")
//    @Operation(summary = "Delete commune by ID")
//    public void deleteCommuneById(@PathVariable Long id) {
//        communeService.deleteById(id);
//    }
}
