package fr.uga.miage.m1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Etape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etape;
    

    @Column(name="prix", nullable = false)
    private float prix;

    @OneToMany(mappedBy = "etape", cascade = CascadeType.ALL)
    private List<Panier> Paniers;

}
