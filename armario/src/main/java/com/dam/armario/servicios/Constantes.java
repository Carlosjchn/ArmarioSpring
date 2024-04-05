package com.dam.armario.servicios;

public class Constantes {
    public static final String patronCorreo = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String patronContraseña = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
    public static final String rutaUsuarios = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\docs\\Usuarios.txt";
}
