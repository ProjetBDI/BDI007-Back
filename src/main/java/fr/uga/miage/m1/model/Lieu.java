package fr.uga.miage.m1.model;


import fr.uga.miage.m1.enums.TypeLieu;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "lieu")
public class Lieu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lieu", nullable = false)
    private Long idLieu;

    @Column(name="adresse", nullable = false)
    private String adresse;

    @Column(name="code_insee_lieu", nullable = false)
    private String codeINSEELieu;

    @Column(name="latitude", nullable = false)
    private float latitude;

    @Column(name="longitude", nullable = false)
    private float longitude;

    @Column(name="nom", nullable = false)
    private String nom;

    @Enumerated(EnumType.STRING)
    @Column(name="type_lieu", nullable = false)
    private TypeLieu typeLieu;

    @ManyToOne
    @JoinColumn(name="id_commune", referencedColumnName = "id_commune")
    private Commune idCommune;

    @OneToMany(mappedBy = "idLieu")
    private List<Etape> etapes;

}
