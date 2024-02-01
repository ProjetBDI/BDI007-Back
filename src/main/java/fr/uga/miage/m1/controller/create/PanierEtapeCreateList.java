package fr.uga.miage.m1.controller.create;

import java.util.List;

public class PanierEtapeCreateList {
    private List<PanierEtapeCreate> panierEtapes;

    public List<PanierEtapeCreate> getPanierEtapeCreateList() {
        return panierEtapes;
    }

    public PanierEtapeCreateList(List<PanierEtapeCreate> panierEtapeCreateList) {
        this.panierEtapes = panierEtapeCreateList;
    }

    public PanierEtapeCreateList() {
    }

    public void setPanierEtapeCreateList(List<PanierEtapeCreate> panierEtapeCreateList) {
        this.panierEtapes = panierEtapeCreateList;
    }

    @Override
    public String toString() {
        return "PanierEtapeCreateList{" +
                "panierEtapeCreateList=" + panierEtapes +
                '}';
    }
}
