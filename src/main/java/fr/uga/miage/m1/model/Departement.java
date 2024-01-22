package fr.uga.miage.m1.model;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "departement")
public class Departement {

    @Id
    @Column(name = "departement", nullable = false)
    private String departement;

    @Column(name = "nom_departement", nullable = false)
    private String nomDepartement;

    @OneToMany(mappedBy = "departement") // Utilisation de "mappedBy" pour indiquer le champ dans l'entité liée
    private List<Commune> communes;

    @ManyToOne
    @JoinColumn(name = "nom_region", referencedColumnName = "nom")
    private Region nomRegion;

}