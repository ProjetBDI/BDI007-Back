package fr.uga.miage.m1.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "panier_id_sequence"),
                    @Parameter(name = "initial_value", value = "100000"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @Column(name = "id_panier", nullable = false)
    private Long idPanier;

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
