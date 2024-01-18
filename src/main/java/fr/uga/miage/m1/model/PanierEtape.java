package fr.uga.miage.m1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PanierEtape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nbPlacesOccupees;

    @ManyToMany
    @JoinColumn(name = "idEtape")
    private PanierEtape panierEtape;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;
    
}
