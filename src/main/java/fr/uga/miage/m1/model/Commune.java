package fr.uga.miage.m1.model;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Commune {

    @Id
    @Column(name = "codeINSEE")
    private String codeINSEE;

    @Column(name = "nom")
    private String nom;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @OneToMany(mappedBy = "commune",  cascade = CascadeType.ALL)
    private List<Festival> festivals;

    @OneToMany(mappedBy = "communeLieu",  cascade = CascadeType.ALL)
    private List<Lieu> lieux;
}