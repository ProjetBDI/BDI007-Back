package fr.uga.miage.m1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PanierEtape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPanierEtape;

    @Column(name="etapeLieu")
    private long etapeLieu;

    @Column(name="etapeCovoiturage", nullable = false)
    private long etapeCovoiturage;

    @Column(name="idPanier", nullable = false)
    private long idPanier;

    @Column(name="nbPlaceOccuppe", nullable = false)
    private long nbPlaceOccuppe;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;

    @ManyToMany
    @JoinColumns({
        @JoinColumn(name = "etapeLieu", referencedColumnName = "idLieu", table = "Etape"),
        @JoinColumn(name = "etapeCovoiturage", referencedColumnName = "idCovoiturage", table = "Etape")
    })
    private Etape etape;
    
}
