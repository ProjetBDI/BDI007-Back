package fr.uga.miage.m1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "SousDomaine")
public class SousDomaine {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nomSousDomaine;


    @ManyToOne()
    @JoinColumn(name = "nomDomaine", referencedColumnName = "nomDomaine")
    private Domaine nomDomaine;

    @OneToMany(mappedBy = "sousDomaine")
    private List<Festival> festivals;
}
