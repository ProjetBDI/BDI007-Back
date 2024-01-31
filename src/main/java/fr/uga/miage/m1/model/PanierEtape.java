package fr.uga.miage.m1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="panier_etape")
public class PanierEtape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_panier_etape", nullable = false)
    private Long idPanierEtape;


    @Column(name="nb_place_occuppe", nullable = false)
    private Long nbPlaceOccuppe;

    @ManyToOne
    @JoinColumn(name = "id_etape", referencedColumnName = "id_etape", insertable = false, updatable = false)
    private Etape idEtape;

    @ManyToOne
    @JoinColumn(name = "id_panier", referencedColumnName = "id_panier")
    private Panier idPanier;
}
