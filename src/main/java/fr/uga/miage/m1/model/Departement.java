package fr.uga.miage.m1.model;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Departement {

    @Id
    @Column(name = "departement", nullable = false)
    private String departement;

    @Column(name = "nomDepartement", nullable = false)
    private String nomDepartement;

    @OneToMany
    @JoinColumn(name = "departement", referencedColumnName = "departement", table = "Commune", updatable = true, insertable = true)
    private List<Commune> communes;

    @ManyToOne
    @JoinColumn(name = "nomRegion", referencedColumnName = "nom", table = "Region", nullable = false, updatable = true, insertable = true)
    private Region nomRegion;
}