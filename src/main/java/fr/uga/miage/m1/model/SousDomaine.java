package fr.uga.miage.m1.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class SousDomaine {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nom;


    @ManyToOne()
    private Domaine domaine;

    @OneToMany (mappedBy = "sousDomaine", cascade = CascadeType.ALL)
    private List<Festival> festivals;
}
