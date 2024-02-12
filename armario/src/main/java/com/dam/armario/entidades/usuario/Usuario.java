package com.dam.armario.entidades.usuario;

import java.util.ArrayList;

import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.outfits.*;

public class Usuario{
    private String nombre;
    private String email;
    private String password;
    ArrayList<Ropa> RopaBD = new ArrayList<Ropa>();
    ArrayList<Outfits> OutfitsBD = new ArrayList<Outfits>();

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    public Usuario() {
    }

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ArrayList<Ropa> getRopaBD() {
        return RopaBD;
    }
    public void setRopaBD(ArrayList<Ropa> ropaBD) {
        RopaBD = ropaBD;
    }
    public ArrayList<Outfits> getOutfitsBD() {
        return OutfitsBD;
    }
    public void setOutfitsBD(ArrayList<Outfits> outfitsBD) {
        OutfitsBD = outfitsBD;
    }

}