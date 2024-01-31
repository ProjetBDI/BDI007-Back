package fr.uga.miage.m1.controller.create;

import java.util.List;

public class PanierEtapeCreateList {
    private List<PanierEtapeCreate> panierEtapeCreateList;

    public List<PanierEtapeCreate> getPanierEtapeCreateList() {
        return panierEtapeCreateList;
    }

    public PanierEtapeCreateList(List<PanierEtapeCreate> panierEtapeCreateList) {
        this.panierEtapeCreateList = panierEtapeCreateList;
    }

    public PanierEtapeCreateList() {
    }

    public void setPanierEtapeCreateList(List<PanierEtapeCreate> panierEtapeCreateList) {
        this.panierEtapeCreateList = panierEtapeCreateList;
    }

    @Override
    public String toString() {
        return "PanierEtapeCreateList{" +
                "panierEtapeCreateList=" + panierEtapeCreateList +
                '}';
    }
}
