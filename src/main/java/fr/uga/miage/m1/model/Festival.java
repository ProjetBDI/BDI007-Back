package fr.uga.miage.m1.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.Date;
import java.util.List;

import fr.uga.miage.m1.enums.FestivalStatus;

@Entity
@Data
@Table(name = "Festival")
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFestival;

    @Column(name = "nom")
    private String nom;

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

    @Column(name = "nbPassTotal")
    private int nbPassTotal;

    @Column(name = "nbPassDispo")
    private int nbPassDispo;

    @Column(name = "nbPassIndispo")
    private int nbPassIndispo;

    @Column(name = "status")
    private FestivalStatus status;
    
    @OneToMany
    @JoinColumn(name="idFestival", referencedColumnName = "festival", table = "Covoiturage", insertable = true, nullable = false)
    private List<Covoiturage> covoiturages;

    @ManyToOne
    @JoinColumn(name="commune", referencedColumnName = "codeINSEE" , table = "Commune" , insertable = true, nullable = false)
    private Commune commune;

    @ManyToOne
    @JoinColumn(name="sousDomaine", referencedColumnName = "nomSousDomaine", table = "SousDomaine" , insertable = true, nullable = false)
    private SousDomaine sousDomaine;
}