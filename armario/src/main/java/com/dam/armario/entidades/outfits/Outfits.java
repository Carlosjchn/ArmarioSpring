package com.dam.armario.entidades.outfits;

import com.dam.armario.entidades.ropa.*;

public class Outfits {
    private Ropa torso1;
    private Ropa torso2;
    private Ropa pantalon;
    private Ropa zapatos;
    private Ropa abrigo;
    private Ropa complementos;

    public Outfits(Ropa torso1, Ropa torso2, Ropa pantalon, Ropa zapatos, Ropa abrigo, Ropa complementos) {
        this.torso1 = torso1;
        this.torso2 = torso2;
        this.pantalon = pantalon;
        this.zapatos = zapatos;
        this.abrigo = abrigo;
        this.complementos = complementos;
    }


    public Ropa getTorso1() {
        return torso1;
    }
    public void setTorso1(Ropa torso1) {
        this.torso1 = torso1;
    }
    public Ropa getTorso2() {
        return torso2;
    }
    public void setTorso2(Ropa torso2) {
        this.torso2 = torso2;
    }
    public Ropa getPantalon() {
        return pantalon;
    }
    public void setPantalon(Ropa pantalon) {
        this.pantalon = pantalon;
    }
    public Ropa getZapatos() {
        return zapatos;
    }
    public void setZapatos(Ropa zapatos) {
        this.zapatos = zapatos;
    }
    public Ropa getAbrigo() {
        return abrigo;
    }
    public void setAbrigo(Ropa abrigo) {
        this.abrigo = abrigo;
    }
    public Ropa getComplementos() {
        return complementos;
    }
    public void setComplementos(Ropa complementos) {
        this.complementos = complementos;
    }


    @Override
    public String toString() {
        return "Outfits [torso1=" + torso1 + ", torso2=" + torso2 + ", pantalon=" + pantalon + ", zapatos=" + zapatos
                + ", abrigo=" + abrigo + ", complementos=" + complementos + "]";
    }

}