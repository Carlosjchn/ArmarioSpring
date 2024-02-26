package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.ropa.Ropa;

import ch.qos.logback.core.net.SyslogOutputStream;

public class MenuRopa {
    Scanner sc = new Scanner(System.in);

    public String ropa() {
        System.out.println("Menú de Ropa");
        System.out.println("\t 1. Ver prendas");
        System.out.println("\t 2. Añadir prenda");

        System.out.println("\t 3. Sugerencias");
        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) <= 1 && Integer.parseInt(opcion) >= 2);

        return opcion;
    }

    public ArrayList<String> menuAñadirPrenda() {
        ArrayList<String> opcion = new ArrayList<String>();
        do {
        System.out.println("Eliga un tipo de prenda:");
            System.out.println("\t 1. Abrigo");
            System.out.println("\t 2. Camisa");
            System.out.println("\t 3. Camiseta");
            System.out.println("\t 4. Jerseis");
            System.out.println("\t 5. Pantalon");
            System.out.println("\t 6. Sudadera");
            System.out.println("\t 7. Zapatos");
            System.out.println("\t 8. Salir");
            opcion.add(0,sc.next());
        } while (Integer.parseInt(opcion.get(0)) < 1 && Integer.parseInt(opcion.get(0)) > 7);
        do {
        System.out.println("Elige el color de la prenda:");
            System.out.println("\t 1. Negro");
            System.out.println("\t 2. Blanco");
            System.out.println("\t 3. Azul");
            System.out.println("\t 4. Rojo");
            System.out.println("\t 5. Verde");
            System.out.println("\t 6. Multicolor");
            opcion.add(1,sc.next());
        } while (Integer.parseInt(opcion.get(1)) < 1 && Integer.parseInt(opcion.get(1)) > 6);
        do {
        System.out.println("Elige la talla de tu prenda:");
            System.out.println("\t 1. XS");
            System.out.println("\t 2. S");
            System.out.println("\t 3. M");
            System.out.println("\t 4. L");
            System.out.println("\t 5. XL");
            opcion.add(2,sc.next());
        } while (Integer.parseInt(opcion.get(2)) < 1 && Integer.parseInt(opcion.get(2)) > 5);
        do {
        System.out.println("Elige el material de tu prenda:");
            System.out.println("1. Algodón");
            System.out.println("2. Pana");
            System.out.println("3. Nilon");
            System.out.println("4. Poliester");
            System.out.println("5. Cuero");
            opcion.add(3,sc.next());
        } while (Integer.parseInt(opcion.get(3)) < 1 && Integer.parseInt(opcion.get(3)) > 5);

        return opcion;
    }

}
