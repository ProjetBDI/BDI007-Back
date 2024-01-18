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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFestival;

    @Column(name = "nomFestival")
    private String nomFestival;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDebut")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateFin")
    private Date dateFin;

    @Column(name = "siteWeb")
    private String siteWeb;

    @Column(name = "lieuPrincipal")
    private String lieuPrincipal;
    
    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Covoiturage> covoiturages;

    @ManyToOne
    @JoinColumn(name="codeINSEE")
    private Commune commune;

    @ManyToOne
    @JoinColumn(name="nom")
    private SousDomaine sousDomaine;
}