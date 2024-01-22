package fr.uga.miage.m1.model;

import java.io.Serializable;

public class EtapeId implements Serializable {
    private long idLieu;
    private long idCovoiturage;

    // ... getters, setters, equals, and hashCode 
    public EtapeId() {
    }

    public EtapeId(long idLieu, long idCovoiturage) {
        this.idLieu = idLieu;
        this.idCovoiturage = idCovoiturage;
    }

    // equals() and hashCode()

    public long getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(long idLieu) {
        this.idLieu = idLieu;
    }

    public long getIdCovoiturage() {
        return idCovoiturage;
    }

    public void setIdCovoiturage(long idCovoiturage) {
        this.idCovoiturage = idCovoiturage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtapeId)) return false;

        EtapeId etapeId = (EtapeId) o;

        if (getIdLieu() != etapeId.getIdLieu()) return false;
        return getIdCovoiturage() == etapeId.getIdCovoiturage();
    }

    @Override
    public int hashCode() {
        int result = (int) (getIdLieu() ^ (getIdLieu() >>> 32));
        result = 31 * result + (int) (getIdCovoiturage() ^ (getIdCovoiturage() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "EtapeId{" +
                "idLieu=" + idLieu +
                ", idCovoiturage=" + idCovoiturage +
                '}';
    }

}

