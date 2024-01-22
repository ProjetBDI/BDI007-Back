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
@Table(name = "festival")
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_festival", nullable = false)
    private long idFestival;

    @Column(name = "nom")
    private String nom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "site_web")
    private String siteWeb;

    @Column(name = "lieu_principal")
    private String lieuPrincipal;

    @Column(name = "nb_pass_total")
    private int nbPassTotal;

    @Column(name = "nb_pass_dispo")
    private int nbPassDispo;

    @Column(name = "nb_pas_indispo")
    private int nbPassIndispo;

    @Column(name = "status")
    private FestivalStatus status;
    
    @OneToMany(mappedBy = "festival")
    private List<Covoiturage> covoiturages;

    @ManyToOne
    @JoinColumn(name="commune", referencedColumnName = "code_insee")
    private Commune commune;

    @ManyToOne
    @JoinColumn(name="sous_domaine", referencedColumnName = "nom_sous_domaine")
    private SousDomaine sousDomaine;
}