package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.enums.PanierStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "Panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPanier;

    @Enumerated(EnumType.STRING)
    @Column( name = "status", nullable = false)
    private PanierStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datePaiement", nullable = false)
    private Date datePaiement;

    @Column(name = "nomsFestivaliers", nullable = false)
    private String nomsFestivaliers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proprietaire", referencedColumnName = "email", table = "Utilisateur", insertable = true)
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "idPanier", cascade = CascadeType.ALL)
    @JoinColumn(name = "idPanier", referencedColumnName = "idPanier", table = "PanierEtape", insertable = true)
    private List<PanierEtape> panierEtapes;
    
}
