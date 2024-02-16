package com.dam.armario.servicios;
import java.util.Scanner;

import com.dam.armario.entidades.usuario.*;

import com.dam.armario.repositorio.*;

public class ServicioUsuario {

    UsuarioBD listaUsers= new UsuarioBD();

    public void altaUsuario(String nombre, String email, String password, String recuperar){
        Usuario usuario = new Usuario(nombre, email, password, recuperar);
        listaUsers.altaUsuario(usuario);   
    }

    public void eliminarUsuario(String nombre, String contraseña){
        Usuario a = listaUsers.buscarUsuario(nombre, contraseña);
        if (a!=null){
            listaUsers.eliminarUsuario(a);
        }
    }

    public void logInUsuario(String nombre, String contraseña){
        Usuario a = listaUsers.buscarUsuario(nombre, contraseña);
        listaUsers.setFalse();
        if(a!=null){
            a.setLogueado(true);
        }

    }

    public void modificarUsuario(Scanner sc ) {
        
    }


  

}
