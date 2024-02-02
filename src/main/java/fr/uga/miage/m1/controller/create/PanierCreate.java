package fr.uga.miage.m1.controller.create;

import lombok.Getter;

@Getter
public class PanierCreate {

    private final String nomsFestivaliers;
    private final Long idProprietaire;

    public PanierCreate(
        String nomsFestivaliers,
        Long idProprietaire
    ) {
        this.nomsFestivaliers = nomsFestivaliers;
        this.idProprietaire = idProprietaire;
    }

    @Override
    public String toString() {
        return "PanierCreate{" +
            ", nomsFestivaliers='" + nomsFestivaliers + '\'' +
            ", idProprietaire=" + idProprietaire +
            '}';
    }
}
