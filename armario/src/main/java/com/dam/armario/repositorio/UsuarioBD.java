package com.dam.armario.repositorio;

import java.util.ArrayList;

import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.*;
import com.dam.armario.excepciones.LoginExcepcion;
import com.dam.armario.excepciones.NombreExcepcion;
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

    public Usuario buscarNombre(String nombre) throws NombreExcepcion{
        for (Usuario u : usuarioBD) {
            if (nombre.equalsIgnoreCase(u.getNombre())) {
                return u;
            }
        }
        throw new NombreExcepcion();
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
            buscarSesion().setLogueado(false);
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

    public void comprarPrenda(Usuario vendedor, Ropa Prenda) throws SaldoExcepcion {
        Usuario comprador = buscarSesion();
        try {
            if (comprador.getSaldo() - Prenda.getPrecio() >= 0) {
                comprador.setSaldo(comprador.getSaldo() - Prenda.getPrecio());
                vendedor.setSaldo(vendedor.getSaldo() + Prenda.getPrecio());
                vendedor.removePrenda(Prenda);
                Prenda.setPrecio(0);
                comprador.altaRopa(Prenda);
                updateUsuario(comprador);
                updateUsuario(vendedor);
            } else {
                throw new SaldoExcepcion(); 
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUsuario(Usuario u){
        for(int i = 0; i < usuarioBD.size(); i++){
            if(usuarioBD.get(i).getNombre().equals(u.getNombre())){
                usuarioBD.set(i, u);
            }
        }
    }
   
}
