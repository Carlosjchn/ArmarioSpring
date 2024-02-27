package com.dam.armario.entidades.outfits;

import java.util.ArrayList;

import com.dam.armario.entidades.ropa.*;

public class Outfits {
    private String nombreOutfit;
    private ArrayList<Ropa> NuevoOutfit = new ArrayList<Ropa>();
    
    public Outfits(String nombreOutfit, ArrayList<Ropa> nuevoOutfit) {
        this.nombreOutfit = nombreOutfit;
        NuevoOutfit = nuevoOutfit;
    }

    public Outfits() {
    }
    
    public ArrayList<Ropa> getNuevoOutfit() {
        return NuevoOutfit;
    }

    public void setRopaBD(Ropa nuevaRopa) {
        NuevoOutfit.add(nuevaRopa);
    }

    
    public String getNombreOutfit() {
        return nombreOutfit;
    }
    
    public void setNombreOutfit(String nombreOutfit) {
        this.nombreOutfit = nombreOutfit;
    }
    
    public void setNuevoOutfit(ArrayList<Ropa> nuevoOutfit) {
        NuevoOutfit = nuevoOutfit;
    }
    
    

    @Override
    public String toString() {
        return "Outfits [" +  NuevoOutfit + "]";
    }
    

}