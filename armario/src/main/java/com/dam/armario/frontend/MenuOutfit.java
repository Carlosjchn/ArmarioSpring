package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.outfits.Outfits;
import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.ServicioRopa;

public class MenuOutfit {
    Scanner sc = new Scanner(System.in);
    ServicioRopa funcionesRopa = new ServicioRopa();

    public String outfit() {
        System.out.println("Menú de Outfits");
        System.out.println("\t 1. Ver outfits");
        System.out.println("\t 2. Crear outfit");
        System.out.println("\t 3. Eliminar outfit");
        System.out.println("\t 4. Salir");

        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) <= 1 && Integer.parseInt(opcion) >= 2);

        return opcion;

    }

    public ArrayList<String> crearOutfit(UsuarioBD listaUsuarios) {
        ArrayList<String> opcionesOutfit = new ArrayList<>();
        String posicionPrenda;
        funcionesRopa.mostrar(listaUsuarios.buscarSesion());
        do {
            System.out.println("Elige el numero prenda para tu Outfit o escribir 'salir' para terminar crear.");
            posicionPrenda = sc.next();
            if (posicionPrenda.equalsIgnoreCase("salir") == false) {
                opcionesOutfit.add(posicionPrenda);
            }
        } while (posicionPrenda.equalsIgnoreCase("salir") == false);

        System.out.println("Dale un nombre a tu Outfit:");
        String nombreOutfit = sc.next();
        opcionesOutfit.add(nombreOutfit);

        return opcionesOutfit;
    }

    public void listaOufits(Outfits outfit, int iteraciones) {
        System.out.println(iteraciones + ". " + outfit.getNombreOutfit());
    }

    public String elegirOutfit() {
        System.out.println("Elige el numero del outfit que quieres ver:");
        String numeroOutfit = sc.next();
        return numeroOutfit;
    }

    public void imprimirOutfit(Outfits outfit) {
        System.out.println(outfit.getNombreOutfit());
        int iteraciones = 0;
        for (Ropa prenda : outfit.getNuevoOutfit()) {
            iteraciones++;
            System.out.println("\t" + iteraciones + " - " + prenda);
        }
    }

    public void noHayOutfit() {
        System.out.println("No hay outfits creados todavía.");
    }

    public void errorOutfit() {
        System.out.println("El número de outfit introducido no es válido");
    }

    public int eliminarOutfit(Usuario u) {
        int opcion = 0;
        do {
            System.out.println("Elige el número del outfit que quieres eliminar: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            }
        } while (sc.hasNextInt() == false);
        return opcion;
    }
}
