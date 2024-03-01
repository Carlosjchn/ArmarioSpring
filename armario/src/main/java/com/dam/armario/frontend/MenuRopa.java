package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;

public class MenuRopa {
    Scanner sc = new Scanner(System.in);

    public String ropa() {
        System.out.println("Menú de Ropa");
        System.out.println("\t 1. Ver prendas");
        System.out.println("\t 2. Añadir prenda");
        System.out.println("\t 3. Eliminar prenda");
        System.out.println("\t 4. Salir");
        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) <= 1 && Integer.parseInt(opcion) >= 2);

        return opcion;
    }

    public ArrayList<String> menuAñadirPrenda() {
        ArrayList<String> opcion = new ArrayList<String>();

        opcion = elegirRopa(opcion);
        if (Integer.parseInt(opcion.get(0)) < 8) {
            opcion = elegirColor(opcion);
            opcion = elegirTalla(opcion);
            opcion = elegirMarca(opcion);
            opcion = elegirMaterial(opcion);
            // hecho por josca, chamo borralo to si esta mal
            opcion = elegirAtributos(opcion);
            return opcion;
        } else {
            return null;
        }
    }

    public ArrayList<String> elegirRopa(ArrayList<String> opcion) {
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
            opcion.add(0, sc.next());
        } while (Integer.parseInt(opcion.get(0)) < 1 && Integer.parseInt(opcion.get(0)) > 7);
        return opcion;
    }

    public ArrayList<String> elegirColor(ArrayList<String> opcion) {
        do {
            System.out.println("Elige el color de la prenda:");
            System.out.println("\t 1. Negro");
            System.out.println("\t 2. Blanco");
            System.out.println("\t 3. Azul");
            System.out.println("\t 4. Rojo");
            System.out.println("\t 5. Verde");
            System.out.println("\t 6. Multicolor");
            opcion.add(1, sc.next());
        } while (Integer.parseInt(opcion.get(1)) < 1 && Integer.parseInt(opcion.get(1)) > 6);
        return opcion;
    }

    public ArrayList<String> elegirTalla(ArrayList<String> opcion) {
        do {
            if (opcion.get(0).equals("7")) {
                System.out.println("Elige la talla de tu prenda:");
                System.out.println("\t 1. 35-36");
                System.out.println("\t 2. 37-38");
                System.out.println("\t 3. 38-39");
                System.out.println("\t 4. 40-41");
                System.out.println("\t 5. 41+");
                opcion.add(2, sc.next());
            } else {
                System.out.println("Elige la talla de tu prenda:");
                System.out.println("\t 1. XS");
                System.out.println("\t 2. S");
                System.out.println("\t 3. M");
                System.out.println("\t 4. L");
                System.out.println("\t 5. XL");
                opcion.add(2, sc.next());
            }
        } while (Integer.parseInt(opcion.get(2)) < 1 && Integer.parseInt(opcion.get(2)) > 5);
        return opcion;
    }

    public ArrayList<String> elegirMarca(ArrayList<String> opcion) {
        do {
            System.out.println("Escribe la marca de tu prenda:");
            opcion.add(3, sc.next());
        } while (opcion.get(3) == null);
        return opcion;
    }

    public ArrayList<String> elegirMaterial(ArrayList<String> opcion) {
        do {
            System.out.println("Elige el material de tu prenda:");
            System.out.println("\t 1. Algodón");
            System.out.println("\t 2. Pana");
            System.out.println("\t 3. Nilon");
            System.out.println("\t 4. Poliester");
            System.out.println("\t 5. Cuero");
            opcion.add(4, sc.next());
        } while (Integer.parseInt(opcion.get(4)) < 1 && Integer.parseInt(opcion.get(4)) > 5);
        return opcion;
    }
    /*
     * orden posiciones arraylist:
     * 0. Eleccion de la prenda
     * 1. Color
     * 2. Talla
     * 3. Marca
     * 4. Material
     * 5. Capucha
     * 6. Mangas
     * 7. Estampado
     * 8. Cuello
     * 9. Tela
     * 10. Longitud pantalon
     */

    public ArrayList<String> elegirAtributos(ArrayList<String> opcion) {
        switch (opcion.get(0)) {
            case "1":
                System.out.println("Elige si el abrigo tiene capucha o no: ");
                System.out.println("\t 1. Si tiene capucha");
                System.out.println("\t 2. No tiene capucha");
                opcion.add(5, sc.next());
                break;
            case "2":
                System.out.println("Elige si la camisa tiene mangas cortas o no:");
                System.out.println("\t 1. Si tiene mangas cortas");
                System.out.println("\t 2. Tiene mangas largas");
                opcion.add(5, sc.next());
                System.out.println("Elige si la camisa tiene estampado o no:");
                System.out.println("\t 1. Si tiene estampado");
                System.out.println("\t 2. No tiene estampado");
                opcion.add(6, sc.next());
                break;
            case "3":
                System.out.println("Elige si la camiseta tiene mangas cortas o no:");
                System.out.println("\t 1. Si tiene mangas cortas");
                System.out.println("\t 2. Tiene mangas largas");
                opcion.add(5, sc.next());
                System.out.println("Elige si la camiseta tiene el cuello redondo o de pico");
                System.out.println("\t 1. Si tiene el cuello redondo");
                System.out.println("\t 2. Si tiene el cuello de pico");
                opcion.add(6, sc.next());
                System.out.println("Elige si la camisa tiene estampado o no:");
                System.out.println("\t 1. Si tiene estampado");
                System.out.println("\t 2. No tiene estampado");
                opcion.add(7, sc.next());
                break;
            case "4":
                System.out.println("Elige si el jersey tiene el cuello redondo o de pico");
                System.out.println("\t 1. Si tiene el cuello redondo");
                System.out.println("\t 2. Si tiene el cuello de pico");
                opcion.add(5, sc.next());
                System.out.println("Elige si la tela del jersey es fina o gruesa:");
                System.out.println("\t 1. Si tiene telea fina");
                System.out.println("\t 2. Si tiene telea gruesa");
                opcion.add(6, sc.next());
                break;
            case "5":
                System.out.println("Elige si el pantalon es corto o largo");
                System.out.println("\t 1. Si tiene es corto");
                System.out.println("\t 2. Si tiene es largo");
                opcion.add(5, sc.next());
                break;
            case "6":
                System.out.println("Elige si la sudadera tiene capucha o no: ");
                System.out.println("\t 1. Si tiene capucha");
                System.out.println("\t 2. No tiene capucha");
                opcion.add(5, sc.next());
                System.out.println("Elige si la sudadera tiene estampado o no:");
                System.out.println("\t 1. Si tiene estampado");
                System.out.println("\t 2. No tiene estampado");
                opcion.add(6, sc.next());
                break;
        }
        return opcion;
    }

    public void imprimirPrenda(Ropa prenda, int iteraciones) {
        System.out.println("\t " + iteraciones + ". " + prenda);
    }

    public void tuRopa() {
        System.out.println("Tus prendas registradas son:");
    }

    public void noHayPrendas() {
        System.out.println("Aún no tienes prendas registradas");
    }

    public int eliminarRopa(Usuario u){
        int opcion = 0;
        do {
            System.out.println("Elige el número de la prenda que quieres eliminar: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            }
        } while (sc.hasNextInt() == false);
        return opcion;
    }

}
