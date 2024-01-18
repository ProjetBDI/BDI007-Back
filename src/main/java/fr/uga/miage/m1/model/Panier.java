package fr.uga.miage.m1.model;

import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.enums.PanierStatus;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
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

    @ElementCollection
    @Column(name = "nomsFestivaliers", nullable = false)
    private List<String> nomsFestivaliers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEtape")
    private Etape etape;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<PanierEtape> panierEtapes;
    
}
