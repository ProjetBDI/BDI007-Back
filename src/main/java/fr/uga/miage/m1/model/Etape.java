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
@Table(name="Etape")
@IdClass(EtapeId.class)
public class Etape {
    
    @Id
    @Column(name="idLieu", nullable = false)
    private long idLieu;

    @Id
    @Column(name="idCovoiturage", nullable = false)
    private long idCovoiturage;

    @Column(name="prixEtape", nullable = false)
    private float prixEtape;

    @Column(name="dureeDepuisDepart", nullable = false) 
    private int dureeDepuisDepart;

    @ManyToOne
    @JoinColumn(name = "idLieu", referencedColumnName = "idLieu", insertable = false, updatable = false)
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage", referencedColumnName = "idCovoiturage", insertable = false, updatable = false)
    private Covoiturage covoiturage;

    @OneToMany(mappedBy = "etape")
    private List<PanierEtape> panierEtapes;
    
}
