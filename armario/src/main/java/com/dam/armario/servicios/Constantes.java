package com.dam.armario.servicios;

public class Constantes {
    public static final String patronCorreo = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String patronContraseña = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
    public static final String rutaDocs = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\docs\\";
    public static final String rutaInfo = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\logs\\registro.log";
    public static final String rutaError = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\logs\\errores.log";
}
