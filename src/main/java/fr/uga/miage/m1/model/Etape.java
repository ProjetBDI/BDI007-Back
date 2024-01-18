package fr.uga.miage.m1.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Etape {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtape;

    @Column(name="prix", nullable = false)
    private float prix;

    @OneToMany(mappedBy = "idPanier", cascade = CascadeType.ALL)
    private List<Panier> paniers;

    @ManyToOne
    @JoinColumn(name = "idCovoiturage")
    private Covoiturage covoiturage;

    @ManyToMany(mappedBy = "panierEtape")
    private List<PanierEtape> paniersEtape;
    
}
