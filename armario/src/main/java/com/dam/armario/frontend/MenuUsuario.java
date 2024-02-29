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
        String opcion= sc.next();
        System.out.println("Escribe tu contraseña:");
        String contra = sc.next();
        if(contra.equalsIgnoreCase(u.getPassword())){
        return opcion;
        }else{
            return null;
        }
    }

    public String datosModificar(Usuario u, String tipoDato) {
        System.out.println("Escribe tu nuevo " + tipoDato);
        String dato = "";
        if(tipoDato.equalsIgnoreCase("password")) {
            do {
                System.out.println("La contraseña debe tener al menos 8 caracteres y contener al menos una letra minúscula, una letra mayúscula, un dígito y un carácter especial entre los especificados (@#$%^&+=!)");
                dato=sc.next();
                if(funcionComun.validarContrasena(dato) == false){
                    System.out.println("Introduce una contraseña válida.");
                }
            } while (funcionComun.validarContrasena(dato) == false);
        }else if(tipoDato.equalsIgnoreCase("email")){
            do {
                dato = sc.next();
                if(funcionComun.validarCorreoElectronico(dato) == false){
                    System.out.println("Introduce un correo válido.");
                }
            } while (funcionComun.validarCorreoElectronico(dato) == false);
        }else {
            dato = sc.next();
        }
        return dato;
    }
}
