package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.servicios.ServicioComun;

public class MenuUsuario {
    Scanner sc = new Scanner(System.in);
    ServicioComun funcionComun = new ServicioComun();

    public void verPerfil(Usuario u) {
        System.out.println("Informacion de tu perfil:");
        System.out.println("\t 1. Nombre: " + u.getNombre());
        System.out.println("\t 2. Email: " + u.getEmail());
        System.out.println("\t 3. Contraseña: " + u.cifrarPassword());
        System.out.println("\t 4. Saldo: " + u.getSaldo());
        System.out.println("\t    Numero de prendas: " + u.getRopaBD().size());
        System.out.println("\t    Nuemro de outfits creados: " + u.getOutfitsBD().size());
        System.out.println("\t 5. Volver");
    }

    public String modificarPerfil(Usuario u) {
        System.out.println("Elige que quieres modificar:");
        String opcion = sc.next();
        System.out.println("Escribe tu contraseña:");
        String contra = sc.next();
        if (contra.equalsIgnoreCase(u.getPassword())) {
            return opcion;
        } else {
            return null;
        }
    }

    public String datosModificar(String opcion) {
        String dato = "";
        switch(opcion){
            case "1":
                dato = modificarNombre();
            case "2":
                dato = modificarEmail();
                break;
            case "3":
                dato = modificarPassword();
                break;
            case "4":
                dato = añadirSaldo();
                break;
            default:
            break;
        }
        return dato;
    }

    public String modificarNombre() {
        System.out.println("Introduce tu nuevo nombre: ");
        String dato = sc.next();
        return dato;
    }

    public String modificarPassword() {
        String dato;
        do {
            System.out.println(
                    "La contraseña debe tener al menos 8 caracteres y contener al menos una letra minúscula, una letra mayúscula, un dígito y un carácter especial entre los especificados (@#$%^&+=!)");
            dato = sc.next();
            if (funcionComun.validarContrasena(dato) == false) {
                System.out.println("Introduce una contraseña válida.");
            }
        } while (funcionComun.validarContrasena(dato) == false);
        return dato;
    }

    public String modificarEmail() {
        String dato;
        do {
            System.out.println("Introduce tu nuevo correo: ");
            dato = sc.next();
            if (funcionComun.validarCorreoElectronico(dato) == false) {
                System.out.println("Introduce un correo válido.");
            }
        } while (funcionComun.validarCorreoElectronico(dato) == false);
        return dato;
    }

    public String añadirSaldo() {
        String saldo = "";
            System.out.println("Introduce la cantidad a añadir:");
            do {
                if (sc.hasNextInt()) {
                    Float numero = sc.nextFloat();
                    saldo = numero + "";
                }else{
                    System.out.println("Numero no válido.");
                }
            } while (sc.hasNextInt() == false);
            System.out.println("¡Has ingresado : " + saldo + " en tu cuenta!");
            return saldo;
        
    }
}
