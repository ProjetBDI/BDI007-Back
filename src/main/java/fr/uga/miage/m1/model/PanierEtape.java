package fr.uga.miage.m1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="panier_etape")
public class PanierEtape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPanierEtape;

    @Column(name="etape_lieu", nullable = false)
    private long etapeLieu;

    @Column(name="etape_covoiturage", nullable = false)
    private long etapeCovoiturage;

    @Column(name="nb_place_occuppe", nullable = false)
    private long nbPlaceOccuppe;

    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;

    @ManyToOne
    @JoinColumn(name = "etape_lieu", referencedColumnName = "id_lieu", insertable = false, updatable = false)
    @JoinColumn(name = "etape_covoiturage", referencedColumnName = "id_covoiturage", insertable = false, updatable = false)
    private Etape etape;
    
}
