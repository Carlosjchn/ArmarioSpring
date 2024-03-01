package com.dam.armario.frontend;

import java.util.*;


import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.ServicioOutfit;
import com.dam.armario.servicios.ServicioRopa;
import com.dam.armario.servicios.ServicioTienda;

public class MenuTienda {
    Scanner sc = new Scanner(System.in);
    ServicioTienda funcionesTienda = new ServicioTienda();
    ServicioRopa funcionesRopa = new ServicioRopa();

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

    public String tiendaPersonal(UsuarioBD listaUsuarios) {
        String opcion;
        try {
            do {
                System.out.println("¿Qué deseas hacer con tu tienda personal?");
                System.out.println("\t 1. Ver prenda a la venta");
                System.out.println("\t 2. Poner prenda a la venta.");
                System.out.println("\t 3. Eliminar prenda a la venta.");
                System.out.println("\t 4. Volver.");

                System.out.println("Elige una opcion: \t");
                opcion = sc.next();
            } while (Integer.parseInt(opcion) < 1 || Integer.parseInt(opcion) > 4);
            return opcion;
            
        } catch (Exception e) {
            return null;
        }
    }

    public String ponerPrendaVenta(UsuarioBD listaUsuarios) {
        funcionesRopa.mostrar(listaUsuarios.buscarSesion());
        System.out.println("Elige el número de la prenda que deseas poner a la venta: ");
        String numeroPrenda = sc.next();
        return numeroPrenda;
    }

    public double ponerPrecio(){
        System.out.println("Introduce el precio de la prenda: ");
        double precio = sc.nextDouble();
        return precio;
    }

    public void mostrarPrendasVenta(Usuario u) {
        System.out.println("Tus prendas a la venta: ");
        for (Ropa prendaVenta : u.getRopaBD()) {
            if (prendaVenta.getPrecio() != 0) {
                int i = 0;
                System.out.println(i++ + ". " + prendaVenta + " " + prendaVenta.getPrecio() + " euros");
            }
        }
    }

    public Usuario comprarVendedor(UsuarioBD listaUsuarios) {
        System.out.println(listaUsuarios.getVendedores());
        System.out.println("Escribe el nombre del usuario que quieres ver: ");
        String vendedor = sc.next();
        Usuario usuarioVendedor = listaUsuarios.buscarNombre(vendedor);
        return usuarioVendedor;
    }

    public int comprarPrenda(Usuario usuarioVendedor){
        if (usuarioVendedor != null) {
            System.out.println("Vendedor no encontrado:");
        } else {
            mostrarPrendasVenta(usuarioVendedor);
            System.out.println("Elige la prenda que quieras comprar");
            int numeroPrenda = sc.nextInt();
            return numeroPrenda;
        }
        return 0;
    }

    public void errorCompra(){
        System.out.println("Saldo insuficiente.");
    }

    public String eliminarVenta(UsuarioBD listaUsuarios){
        mostrarPrendasVenta(listaUsuarios.buscarSesion());
        System.out.println("Elige la prenda que quieras eliminar:");
        String numPrenda = sc.next();
        return numPrenda;
    }
}
