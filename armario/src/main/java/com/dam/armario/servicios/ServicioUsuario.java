package com.dam.armario.servicios;

import com.dam.armario.entidades.usuario.*;
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
        Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
        if (a != null) {
            listaUsers.eliminarUsuario(a);
        }
    }

    public boolean logInUsuario(UsuarioBD listaUsers, String[] datos) {
        Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
        listaUsers.setFalse();
        if (a != null) {
            a.setLogueado(true);
            return true;
        }else{
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
            u.setSaldo(Double.parseDouble(menuUsuario.datosModificar(opcion)));
            break;
            default:
            System.out.println("Contraseña errónea.");
            
        }
    }

}
