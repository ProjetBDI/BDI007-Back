package fr.uga.miage.m1.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "utilisateur_id_sequence"),
                    @Parameter(name = "initial_value", value = "100000"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @Column(name = "id_utilisateur", nullable = false)
    private Long idUtilisateur;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "mot_de_passe", nullable = true)
    private String motDePasse;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance", nullable = false)
    private Date dateNaissance;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "idProprietaire")
    private List<Panier> paniers;

    @OneToMany(mappedBy = "idConducteur")
    private List<Covoiturage> covoiturages;

}

