package fr.uga.miage.m1.model;

import java.io.Serializable;
import java.util.Objects;

public class SousDomaineId implements Serializable {
    private String nomSousDomaine;
    private String nomDomaine;

    public SousDomaineId() {
        this.nomDomaine = "";
        this.nomSousDomaine  = "";
    }

    public SousDomaineId(String nomSousDomaine, String nomDomaine) {
        this.nomSousDomaine = nomSousDomaine;
        this.nomDomaine = nomDomaine;
    }

    public String getNomSousDomaine() {
        return nomSousDomaine;
    }

    public void setNomSousDomaine(String nomSousDomaine) {
        this.nomSousDomaine = nomSousDomaine;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SousDomaineId that = (SousDomaineId) o;
        return Objects.equals(getNomSousDomaine(), that.getNomSousDomaine()) && Objects.equals(getNomDomaine(), that.getNomDomaine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomSousDomaine(), getNomDomaine());
    }


    @Override
    public String toString() {
        return "SousDomaineId{" +
                "nomSousDomaine='" + nomSousDomaine + '\'' +
                ", nomDomaine='" + nomDomaine + '\'' +
                '}';
    }
}
