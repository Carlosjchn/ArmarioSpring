package com.dam.armario.frontend;

import java.util.Scanner;

public class MenuOutfit {
    Scanner sc = new Scanner(System.in);

    public String outfit(){
        System.out.println("Menú de Outfits");
        System.out.println("\t 1. Ver outfits");
        System.out.println("\t 2. Crear outfit");
        System.out.println("\t 3. Sugerencias");

        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) <= 1 && Integer.parseInt(opcion) >= 2);

        return opcion;

        
    }
}
