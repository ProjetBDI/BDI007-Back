package fr.uga.miage.m1.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Domaine")
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nomDomaine;

    @OneToMany(mappedBy = "nomDomaine")
    private List<SousDomaine> sousDomaines;
}
