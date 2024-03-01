package com.dam.armario.frontend;

import java.util.Scanner;

public class MenuPrincipal {
    Scanner sc = new Scanner(System.in);

    public String principal() {
        try{
        System.out.println("Menú Principal");
        System.out.println("\t 1. Ropa \n\t 2. Outfits \n\t 3. Tienda \n\t 4. Perfil \n\t 5. Cerrar sesion.");
        String opcion;
        
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
            return opcion; 
        
        }catch(Exception e){
            System.out.println("Error");
            return null;
        }
    }   

    public void cerrarApp(){
        System.out.println("Cerrando sesion...");
    }
}
