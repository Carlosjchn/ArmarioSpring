package com.dam.armario.repositorio;

import java.util.ArrayList;

import com.dam.armario.entidades.usuario.*;
import com.dam.armario.excepciones.LoginExcepcion;
import com.dam.armario.excepciones.SaldoExcepcion;

// ENVIAR LA BASE DE DATOS A CADA CONTROLADOR PARA QUE SE ACTUALIZE.
public class UsuarioBD {
    private ArrayList<Usuario> usuarioBD = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarioBD() {
        return usuarioBD;
    }

    public void altaUsuario(Usuario u) {
        usuarioBD.add(u);
    }

    public void eliminarUsuario(Usuario u) {
        usuarioBD.remove(u);
    }

    public Usuario buscarUsuario(String nombre, String contraseña) throws LoginExcepcion {
        for (Usuario u : usuarioBD) {
            if (nombre.equalsIgnoreCase(u.getNombre()) && contraseña.equals(u.getPassword())) {
                return u;
            }
        }
        throw new LoginExcepcion();
    }

    public Usuario buscarNombre(String nombre) {
        for (Usuario u : usuarioBD) {
            if (nombre.equalsIgnoreCase(u.getNombre())) {
                return u;
            }
        }
        return null;
    }

    public void setFalse() {
        for (Usuario u : usuarioBD) {
            u.setLogueado(false);
        }
    }

    public Usuario buscarSesion() {
        for (Usuario u : usuarioBD) {
            if (u.isLogueado() == true) {
                return u;
            }
        }
        return null;
    }

    public Usuario recuperarContraseña(String recuperar) {
        for (Usuario u : usuarioBD) {
            if (recuperar.equals(u.getRecuperar())) {
                return u;
            }
        }
        return null;
    }

    public void cerrarSesion() {
        for (Usuario u : usuarioBD) {
            u.setLogueado(false);
        }
    }

    public ArrayList<Usuario> getVendedores() {
        ArrayList<Usuario> vendedores = new ArrayList<>();
        for (Usuario u : usuarioBD) {
            if (u.isLogueado() == false) {
                vendedores.add(u);
            }
        }
        return vendedores;
    }

    public boolean comprarPrenda(Usuario vendedor, int numPrenda) throws SaldoExcepcion {
        Usuario comprador = buscarSesion();
        try {
            if (comprador.getSaldo() - vendedor.getRopaBD().get(numPrenda).getPrecio() >= 0) {
                comprador.setSaldo(comprador.getSaldo() - vendedor.getRopaBD().get(numPrenda - 1).getPrecio());
                comprador.altaRopa(vendedor.getRopaBD().get(numPrenda - 1));
                vendedor.setSaldo(vendedor.getSaldo() + vendedor.getRopaBD().get(numPrenda - 1).getPrecio());
                vendedor.removePrenda(numPrenda - 1);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
