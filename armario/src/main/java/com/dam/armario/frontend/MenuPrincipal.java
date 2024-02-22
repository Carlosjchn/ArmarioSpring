package com.dam.armario.frontend;

import java.util.Scanner;

public class MenuPrincipal {
    Scanner sc = new Scanner(System.in);

    public String principal() {
        System.out.println("\t 1. Ropa \n\t 2. Outfits \n\t 3. Tienda \n\t 4. Perfil \n\t 5. Cerrar sesion.");
        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) < 1 && Integer.parseInt(opcion) > 4);
        return opcion;
    }   

    
}
