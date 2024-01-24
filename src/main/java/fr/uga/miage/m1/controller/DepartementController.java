package fr.uga.miage.m1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.DepartementDTO;
import fr.uga.miage.m1.mapper.DepartementMapper;
import fr.uga.miage.m1.service.DepartementService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departement", produces = "application/json")
public class DepartementController {
    
    @Autowired
    private final DepartementService departementService;
    @Autowired
    private final DepartementMapper departementMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartementDTO getDepartement(@PathVariable("id") Long id) {
        return departementMapper.entityToDTO(departementService.getById(id));
    }

}
