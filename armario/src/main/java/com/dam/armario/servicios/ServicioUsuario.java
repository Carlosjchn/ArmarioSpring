package com.dam.armario.servicios;

import com.dam.armario.entidades.usuario.*;
import com.dam.armario.excepciones.LoginExcepcion;
import com.dam.armario.frontend.MenuUsuario;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.interfaz.InterfazGeneral;

import java.util.*;

public class ServicioUsuario implements InterfazGeneral {
    MenuUsuario menuUsuario = new MenuUsuario();

    public void alta(ArrayList<String> datos, UsuarioBD listaUsers) {
        Usuario usuario = new Usuario(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
        listaUsers.altaUsuario(usuario);
    }

    public void eliminarUsuario(UsuarioBD listaUsers, String[] datos) {
       try {
        Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
            listaUsers.eliminarUsuario(a);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public boolean logInUsuario(UsuarioBD listaUsers, String[] datos) {

        try {
            Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
            listaUsers.setFalse();
            a.setLogueado(true);
            return true;
        } catch (LoginExcepcion e) {
            System.err.println(e.getMessage());
            return false;
        }
        

    }

    public boolean checkSesion(UsuarioBD listaUsers) {
        if (listaUsers.buscarSesion() != null) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario recuperarUsuario(UsuarioBD listaUsers, String recuperar) {
        return listaUsers.recuperarContraseña(recuperar);
    }

    public void mostrar(Usuario u) {
        menuUsuario.verPerfil(u);
    }

    public void modificarPerfil(Usuario u) {
        mostrar(u);
        String opcion = menuUsuario.modificarPerfil(u);
        switch(opcion) {
            case "1": //Cambiar nombre de usuario
            u.setNombre(menuUsuario.datosModificar(opcion));
            break;
            case "2": //Cambiar email
            u.setEmail(menuUsuario.datosModificar(opcion));
            break;
            case "3": //Cambiar contraseña
            u.setPassword(menuUsuario.datosModificar(opcion));
            break;
            case "4": //Añadir saldo
            u.añadirSaldo(menuUsuario.datosModificar(opcion));
            break;
            default:
                menuUsuario.errorContraseña();
            
        }
    }

    public void eliminar(Usuario u){
        
    }
}
