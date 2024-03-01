package com.dam.armario.servicios;

import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.excepciones.CompraPrendaExcepcion;
import com.dam.armario.excepciones.SaldoExcepcion;
import com.dam.armario.frontend.MenuTienda;
import com.dam.armario.repositorio.UsuarioBD;

public class ServicioTienda {
    MenuTienda menuTienda = new MenuTienda();

    public void tiendaPersonal(UsuarioBD listaUsarios) {
        String opcion = menuTienda.tiendaPersonal(listaUsarios);
        try {
            switch (opcion) {
                case "1":
                    menuTienda.mostrarPrendasVenta(listaUsarios.buscarSesion());
                    break;
                case "2":
                    String numPrenda = menuTienda.ponerPrendaVenta(listaUsarios);
                    double precioPrenda = menuTienda.ponerPrecio();
                    venderPrenda(listaUsarios.buscarSesion(), numPrenda, precioPrenda);
                    break;
                case "3":
                    String eliminarPrenda = menuTienda.eliminarVenta(listaUsarios);
                    listaUsarios.buscarSesion().retirarPrenda(eliminarPrenda);
                    break;
            }
        } catch (Exception e) {

        }
    }

    public void venderPrenda(Usuario u, String index, double precio) {
        u.venderPrenda(index, precio);
    }

    public void comprarPrenda(UsuarioBD listaUsuarios) {
        try {
            Usuario vendedor = menuTienda.comprarVendedor(listaUsuarios);
            int numeroPrenda = menuTienda.comprarPrenda(vendedor);
            listaUsuarios.comprarPrenda(vendedor, numeroPrenda);
        } catch (SaldoExcepcion | CompraPrendaExcepcion e) {
            System.err.println(e.getMessage());
        }
    }

}
