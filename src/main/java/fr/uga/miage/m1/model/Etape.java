package fr.uga.miage.m1.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="etape")
@IdClass(EtapeId.class)
public class Etape {
    
    @Id
    @Column(name="id_lieu", nullable = false)
    private long idLieu;

    @Id
    @Column(name="id_covoiturage", nullable = false)
    private long idCovoiturage;

    @Column(name="prix_etape", nullable = false)
    private float prixEtape;

    @Column(name="duree_depuis_depart", nullable = false)
    private int dureeDepuisDepart;

    @ManyToOne
    @JoinColumn(name = "id_lieu", referencedColumnName = "id_lieu", insertable = false, updatable = false)
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "id_covoiturage", referencedColumnName = "id_covoiturage", insertable = false, updatable = false)
    private Covoiturage covoiturage;

    @OneToMany(mappedBy = "etape")
    private List<PanierEtape> panierEtapes;
    
}
