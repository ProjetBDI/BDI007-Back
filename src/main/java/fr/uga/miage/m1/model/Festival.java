package fr.uga.miage.m1.model;


import jakarta.persistence.*;
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
    private long id_festival;

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

    @Column(name = "nb_pass_indispo")
    private int nbPassIndispo;

    @Column(name = "tarif_pass")
    private float tarifPass;

    @Column(name = "status")
    private FestivalStatus status;
    
    @OneToMany(mappedBy = "id_festival")
    private List<Covoiturage> covoiturages;

    @ManyToOne
    @JoinColumn(name="id_commune", referencedColumnName = "id_commune")
    private Commune id_commune;

    @ManyToOne
    @JoinColumn(name="id_domaine", referencedColumnName = "id_domaine")
    private Domaine id_domaine;
}