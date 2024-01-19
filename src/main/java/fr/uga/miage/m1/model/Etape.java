package fr.uga.miage.m1.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Etape")
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
    @JoinColumn(name = "idLieu", referencedColumnName = "idLieu", table = "Lieu", insertable = true, updatable = true)
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage", referencedColumnName = "idCovoiturage", table = "Covoiturage", insertable = true, updatable = true)
    private Covoiturage covoiturage;

    @ManyToMany
    @JoinColumns({
        @JoinColumn(name = "idLieu", referencedColumnName = "idEtape", table = "Lieu"),
        @JoinColumn(name = "idCovoiturage", referencedColumnName = "etapeCovoiturage", table = "Lieu")
    })
    private List<PanierEtape> paniersEtape;
    
}
