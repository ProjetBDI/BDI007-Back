package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.enums.PanierStatus;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_panier;

    @Enumerated(EnumType.STRING)
    @Column( name = "status", nullable = false)
    private PanierStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_paiement", nullable = false)
    private Date datePaiement;

    @ElementCollection
    @Column(name = "nomsFestivaliers", nullable = false)
    private List<String> nomsFestivaliers;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_etape")
    private Etape etape;

    // Getters and setters

    public Long getId() {
        return id_panier;
    }

    public void setId(Long id_panier) {
        this.id_panier = id_panier;
    }
}
