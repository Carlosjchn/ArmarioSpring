package com.dam.armario.frontend;

import java.util.*;

import com.dam.armario.entidades.outfits.Outfits;
import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.ServicioOutfit;
import com.dam.armario.servicios.ServicioRopa;

public class MenuTienda {
    Scanner sc = new Scanner(System.in);

    public String Tienda(UsuarioBD listaUsuarios) {
        System.out.println("Menú de Tienda: ");
        System.out.println("\t 1. Ver tienda de otros usuarios.");
        System.out.println("\t 2. Ver tienda de " + listaUsuarios.buscarSesion().getNombre());

        String opcion;
        do {
            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) <= 1 && Integer.parseInt(opcion) >= 2);

        return opcion;
    }

    public void verOfertas(UsuarioBD listaUsuarios) {
        int iteraciones = 0;
        ArrayList<Usuario> vendedores = listaUsuarios.getVendedores();
        ServicioOutfit funcionesOutfit = new ServicioOutfit();
        for (Usuario u : vendedores) {
            iteraciones++;
            System.out.println(iteraciones + " - " + u.getNombre());
        }
        String numeroOpcion = sc.next();
        Usuario vendedor = vendedores.get(Integer.parseInt(numeroOpcion) - 1);
        funcionesOutfit.mostrarAlaVenta(vendedor);
        numeroOpcion = sc.next();
        funcionesOutfit.verOutfit(numeroOpcion, vendedor);
    }

    public void tiendaPersonal(UsuarioBD listaUsuarios) {
        ServicioRopa funcionesRopa = new ServicioRopa();
        funcionesRopa.mostrar(listaUsuarios.buscarSesion());

        String opcion;
        do {
            System.out.println("Qué deseas hacer con tu tienda personal?");
            System.out.println("\t 1. Añadir prenda");
            System.out.println("\t 2. Eliminar prenda");
            System.out.println("\t 3. Modificar prenda");
            System.out.println("\t 4. Volver al menú principal");

            System.out.println("Elige una opcion: \t");
            opcion = sc.next();
        } while (Integer.parseInt(opcion) < 1 || Integer.parseInt(opcion) > 4);

        if (opcion.equals("1")) {
            // Llamar método para añadir prenda
        } else if (opcion.equals("2")) {
            // Llamar método para eliminar prenda
        } else if (opcion.equals("3")) {
            // Llamar método para modificar prenda
        } else {
            // Retornar al menú principal
        }
    }
}
