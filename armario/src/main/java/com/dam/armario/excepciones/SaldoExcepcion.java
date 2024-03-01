package com.dam.armario.excepciones;

public class SaldoExcepcion extends Exception{
    
    @Override
    public String getMessage(){
        return "Saldo insuficiente.";
    }

}
