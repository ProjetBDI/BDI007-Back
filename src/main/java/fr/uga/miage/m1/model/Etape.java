package fr.uga.miage.m1.model;

import java.util.List;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="etape")
public class Etape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_etape", nullable = false)
    private long id_etape;

    @Column(name="prix_etape", nullable = false)
    private float prixEtape;

    @Column(name="duree_depuis_depart", nullable = false)
    private int dureeDepuisDepart;

    @ManyToOne
    @JoinColumn(name = "id_lieu", referencedColumnName = "id_lieu", insertable = false, updatable = false)
    private Lieu id_lieu;

    @ManyToOne
    @JoinColumn(name = "id_covoiturage", referencedColumnName = "id_covoiturage", insertable = false, updatable = false)
    private Covoiturage id_covoiturage;

    @OneToMany(mappedBy = "id_etape")
    private List<PanierEtape> panierEtapes;
    
}
