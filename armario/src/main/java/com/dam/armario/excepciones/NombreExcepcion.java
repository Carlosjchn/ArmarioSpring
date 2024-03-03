package com.dam.armario.excepciones;

public class NombreExcepcion extends Exception {
    @Override
    public String getMessage(){
        return "Nombre incorrecto";
    }
}
