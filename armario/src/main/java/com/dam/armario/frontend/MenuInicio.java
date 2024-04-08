package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.servicios.ServicioComun;
import com.dam.armario.servicios.ServiciosLogs;

public class MenuInicio {
    Scanner sc = new Scanner(System.in);
    ServicioComun funcionComun = new ServicioComun();
    ServiciosLogs Logger = new ServiciosLogs();

    public String registro() {
        try {
            System.out.println("Menu Inicio");
            System.out.println("\t 1. Registrarse \n\t 2. Iniciar Sesión \n\t 3. Recuperar cotraseña \n\t 4. Salir ");

            String opcion;

            System.out.println("Elige una opcion: \t");
            opcion = sc.next();

            return opcion;
        } catch (Exception e) {
            Logger.logError(e.getMessage());
            System.out.println("Error al seleccionar opcion");
            return null;
        }
    }

    public ArrayList<String> datosRegistro() {
        ArrayList<String> datos = new ArrayList<String>();
        System.out.println("Introduce tus datos:");
        System.out.println("Nombre: ");
        datos.add(0, sc.next());
        System.out.println("Email: ");
        do {
            datos.add(1, sc.next());
            if (funcionComun.validarCorreoElectronico(datos.get(1)) == false) {
                System.out.println("Introduce un correo válido.");
            }
        } while (funcionComun.validarCorreoElectronico(datos.get(1)) == false);
        System.out.println("Contraseña: ");
        do {
            System.out.println(
                    "La contraseña debe tener al menos 8 caracteres y contener al menos una letra minúscula, una letra mayúscula, un dígito y un carácter especial entre los especificados (@#$%^&+=!)");
            datos.add(2, sc.next());
            if (funcionComun.validarContrasena(datos.get(2)) == false) {
                System.out.println("Introduce una contraseña válida.");
            }
        } while (funcionComun.validarContrasena(datos.get(2)) == false);
        System.out.println("Pregunta de seguridad: \n ¿Nombre de tu primera mascota?: ");
        datos.add(3, sc.next());
        return datos;
    }

    public String[] datosLogin() {
        String[] datos = new String[2];
        System.out.println("Introduce tus datos para iniciar sesión:");
        System.out.println("Nombre: ");
        datos[0] = sc.next();
        System.out.println("Contraseña: ");
        datos[1] = sc.next();
        return datos;
    }

    public String datosRecuperar() {
        String recuperar;
        System.out.println("Pregunta de seguridad: \n" + " ¿Nombre de tu primera mascota?: ");
        recuperar = sc.next();
        return recuperar;
    }

    public void salirApp() {
        System.out.println("Cerrando app...");
    }

    public void recuperarContraseña(Usuario u) {
        System.out.println("La contraseña para el usuario: " + u.getNombre() + " es: \n \t" + u.getPassword());
    }

    public void errorRecuperar() {
        System.out.println("Respuesta incorrecta.");
        Logger.logError("Error recuperar contraseña.");
    }

    public void loginCorrecto() {
        System.out.println("Inicio de sesión correcto.");
    }

    public void loginError() {
        System.out.println("Error en inicio de sesión");
    }
}
