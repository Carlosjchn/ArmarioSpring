package com.dam.armario.entidades.outfits;

import java.util.ArrayList;

import com.dam.armario.entidades.ropa.*;

public class Outfits{
    public int Id;
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
    
    public void addPrenda(Ropa nuevaRopa) {
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
    
    public ArrayList<Ropa> verOutfit(){
        return NuevoOutfit;
    }
    

    @Override
    public String toString() {
        return "Outfits [" +  NuevoOutfit + "]";
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    

}