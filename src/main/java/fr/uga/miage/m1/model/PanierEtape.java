package fr.uga.miage.m1.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Data
@Table(name = "panier_etape")
public class PanierEtape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "panier_etape_id_sequence"),
                    @Parameter(name = "initial_value", value = "300500"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @Column(name = "id_panier_etape", nullable = false)
    private Long idPanierEtape;


    @Column(name = "nb_place_occuppe", nullable = false)
    private Long nbPlaceOccuppe;

    @ManyToOne
    @JoinColumn(name = "id_etape", referencedColumnName = "id_etape", insertable = false, updatable = false)
    private Etape idEtape;

    @ManyToOne
    @JoinColumn(name = "id_panier", referencedColumnName = "id_panier")
    private Panier idPanier;
}
