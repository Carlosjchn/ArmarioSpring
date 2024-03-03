package com.dam.armario.excepciones;

public class ExcepcionPass extends Exception {
    @Override
    public String getMessage(){
        return "Esa contraseña no es válida";
    }
}
