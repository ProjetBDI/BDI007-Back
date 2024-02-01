package fr.uga.miage.m1.controller.create;

public class PanierEtapeUpdate {
    private final Long idPanierEtape;
    private final Long nbPlaceOccuppe;
    private final Long idEtape;
    private final Long idPanier;

    public Long getIdPanierEtape() {
        return idPanierEtape;
    }

    public Long getNbPlaceOccuppe() {
        return nbPlaceOccuppe;
    }

    public Long getIdEtape() {
        return idEtape;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public PanierEtapeUpdate(Long idPanierEtape, Long nbPlaceOccuppe, Long idEtape, Long idPanier) {
        this.idPanierEtape = idPanierEtape;
        this.nbPlaceOccuppe = nbPlaceOccuppe;
        this.idEtape = idEtape;
        this.idPanier = idPanier;
    }
}
