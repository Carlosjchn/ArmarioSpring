package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.usuario.Usuario;

public class MenuInicio {
    Scanner sc = new Scanner(System.in);

    public String registro() {
        System.out.println("\t 1. Registrarse \n\t 2. Iniciar Sesión \n\t 3. Recuperar cotraseña \n\t 4. Salir ");
        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) < 1 && Integer.parseInt(opcion) > 4);
        return opcion;
    }

    public String[] datosRegistro(){
            String[] datos = new String[4];
            System.out.println("Introduce tus datos:");
            System.out.println("Nombre: ");
            datos[0] = sc.next();
            System.out.println("Email: ");
            datos[1] = sc.next();
            System.out.println("Contraseña: ");
            datos[2] = sc.next();
            System.out.println("Pregunta de seguridad: \n ¿Nombre de tu primera mascota?: ");
            datos[3] = sc.next();
            return datos;
    }

    public String[] datosLogin(){
        String[] datos = new String[2];
            System.out.println("Introduce tus datos para iniciar sesión:");
            System.out.println("Nombre: ");
            datos[0]=sc.next();
            System.out.println("Contraseña: ");
            datos[1]=sc.next();
            return datos;
    }

    public String datosRecuperar(){
        String recuperar;
        System.out.println("Pregunta de seguridad: \n" + " ¿Nombre de tu primera mascota?: ");
        recuperar = sc.next();
        return recuperar;
    }

    public void cerrarSesion(){
        System.out.println("Sesión cerrada con éxito");
    }

    public void recuperarContraseña(Usuario u){
        System.out.println("La contraseña para el usuario: " + u.getNombre() + " es: \n \t" + u.getPassword());
    }

    public void errorRecuperar(){
        System.out.println("Respuesta incorrecta.");
    }
}
