package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_panier", nullable = false)
    private long idPanier;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_paiement", nullable = false)
    private Date datePaiement;

    @Column(name = "noms_festivaliers", nullable = false)
    private String nomsFestivaliers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_utilisateur")
    private Utilisateur idProprietaire;

    @OneToMany(mappedBy = "idPanierEtape")
    private List<PanierEtape> panierEtapes;
    
}
