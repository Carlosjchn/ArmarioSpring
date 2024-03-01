package com.dam.armario.excepciones;

public class LoginExcepcion extends Exception{

    @Override
    public String getMessage(){
        return "Error inicio de sesion";
    }


}
 