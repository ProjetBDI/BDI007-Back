package fr.uga.miage.m1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nomDomaine;

    @OneToMany
    @JoinColumn(name = "nomDomaine", referencedColumnName = "nomDomaine", table = "SousDomaine", insertable = true)
    private SousDomaine sousDomaines;
}
