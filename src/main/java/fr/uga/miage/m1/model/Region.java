package fr.uga.miage.m1.model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data; 

@Entity
@Data
@Table(name = "region")
public class Region {
    
    @Id
    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "nomRegion")
    private List<Departement> departements;

}
