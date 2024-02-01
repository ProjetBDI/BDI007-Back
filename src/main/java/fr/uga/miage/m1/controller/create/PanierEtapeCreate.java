package fr.uga.miage.m1.controller.create;

public class PanierEtapeCreate {
    private final Long nbPlaceOccuppe;
    private final Long idEtape;
    private final Long idPanier;

    public Long getNbPlaceOccuppe() {
        return nbPlaceOccuppe;
    }

    public Long getIdEtape() {
        return idEtape;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public PanierEtapeCreate(Long nbPlaceOccuppe, Long idEtape, Long idPanier) {
        this.nbPlaceOccuppe = nbPlaceOccuppe;
        this.idEtape = idEtape;
        this.idPanier = idPanier;
    }

    @Override
    public String toString() {
        return "PanierEtapeCreate{" +
                "nbPlaceOccupe=" + nbPlaceOccuppe +
                ", idEtape=" + idEtape +
                ", idPanier=" + idPanier +
                '}';
    }
}

