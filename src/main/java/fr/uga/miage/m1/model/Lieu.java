package fr.uga.miage.m1.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Lieu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLieu;

    @Column(name="codeINSEELieu", nullable = false)
    private String codeINSEELieu;

    @Column(name="nom", nullable = false)
    private String nom;

    @Column(name="adresse", nullable = false)
    private String adresse;

    @Column(name="longitude", nullable = false)
    private float longitude;

    @Column(name="latitude", nullable = false)
    private float latitude;

    @ManyToOne()
    @JoinColumn(name="codeINSEE")
    private Commune communeLieu;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL)
    private List<Covoiturage> covoiturages;

}
