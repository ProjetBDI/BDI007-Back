package fr.uga.miage.m1.model;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Departement {

    @Id
    @Column(name = "numero")
    private long idNumero;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "numDepartement", cascade = CascadeType.ALL)
    private List<Commune> communes;

    @ManyToOne
    @JoinColumn(name = "nom")
    private Region region;
}