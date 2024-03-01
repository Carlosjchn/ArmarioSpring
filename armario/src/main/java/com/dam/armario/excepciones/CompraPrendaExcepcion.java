package com.dam.armario.excepciones;

public class CompraPrendaExcepcion extends Exception{
    
    @Override
    public String getMessage(){
        return "Error al elegir prenda";
    }
}
