package fr.uga.miage.m1.model;




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
import lombok.Data;
import java.util.List;

import fr.uga.miage.m1.enums.TypeLieu;

@Entity
@Data
@Table(name = "Lieu")
public class Lieu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idLieu", nullable = false)
    private Long idLieu;

    @Column(name="codeINSEELieu", nullable = false)
    private String codeINSEELieu;

    @Enumerated(EnumType.STRING)
    @Column(name="typeLieu", nullable = false)
    private TypeLieu typeLieu;

    @Column(name="nom", nullable = false)
    private String nom;

    @Column(name="adresse", nullable = false)
    private String adresse;

    @Column(name="longitude", nullable = false)
    private float longitude;

    @Column(name="latitude", nullable = false)
    private float latitude;

    @ManyToOne
    @JoinColumn(name="commune", referencedColumnName = "codeINSEE")
    private Commune commune;

    @OneToMany(mappedBy = "idLieu")
    private List<Etape> etapes;

}
