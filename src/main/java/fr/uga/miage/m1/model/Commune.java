package fr.uga.miage.m1.model;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Commune")
public class Commune {

    @Id
    @Column(name = "codeINSEE", nullable = false)
    private String codeINSEE;

    @Column(name = "nomCommune", nullable = false)
    private String nomCommune;

    @Column(name = "codePostal", nullable = false)
    private String codePostal;

    @Column(name = "longitude", nullable = false)
    private String longitude;

    @Column(name = "latitude", nullable = false)
    private String latitude;

    @OneToMany
    @JoinColumn(name = "codeINSEE", referencedColumnName = "commune", table = "Festival", updatable = true, insertable = true)
    private List<Festival> festivals;

    @OneToMany
    @JoinColumn(name = "codeINSEE", referencedColumnName = "commune", table = "Lieu", updatable = true, insertable = true)
    private List<Lieu> lieux;

    @ManyToOne
    @JoinColumn(name = "departement",referencedColumnName = "departement", table = "Departement", updatable = true, insertable = true, nullable = false )
    private Departement departement;
}