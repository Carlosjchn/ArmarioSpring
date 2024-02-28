package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.usuario.Usuario;

public class MenuUsuario {
    Scanner sc = new Scanner(System.in);

    public void verPerfil(Usuario u) {
        System.out.println("Informacion de tu perfil:");
        System.out.println("\t Nombre: " + u.getNombre());
        System.out.println("\t Email: " + u.getEmail());
        System.out.println("\t Contraseña: " + u.cifrarPassword());
        System.out.println("\t Saldo: " + u.getSaldo());
        System.out.println("\t Numero de prendas: " + u.getRopaBD().size());
        System.out.println("\t Nuemro de outfits creados: " + u.getOutfitsBD().size());
        sc.nextLine();
    }
}
