package com.dam.armario.entidades.usuario;

import java.util.ArrayList;

import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.outfits.*;

public class Usuario {
    private String nombre;
    private String email;
    private String password;
    private String recuperar;
    private boolean Logueado=false;
    
    private ArrayList<Ropa> RopaBD = new ArrayList<Ropa>();
    private ArrayList<Outfits> OutfitsBD = new ArrayList<Outfits>();
    
    public Usuario(String nombre, String email, String password, String recuperar) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.recuperar = recuperar;
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

    public String getRecuperar() {
        return recuperar;
    }

    public void setRecuperar(String recuperar) {
        this.recuperar = recuperar;
    }

    public boolean isLogueado() {
        return Logueado;
    }

    public void setLogueado(boolean logueado) {
        this.Logueado = logueado;
    }
    public ArrayList<Ropa> getRopaBD() {
        return RopaBD;
    }

    public void altaRopa(Ropa ropa) {
        RopaBD.add(ropa);
    }

    public ArrayList<Outfits> getOutfitsBD() {
        return OutfitsBD;
    }

    public void altaOutfit(Outfits outfit) {
        OutfitsBD.add(outfit);
    }

    public void elegirOutfit(int index){
        OutfitsBD.get(index - 1);
    }

}