package com.dam.armario.servicios;
import java.util.Scanner;

import com.dam.armario.entidades.usuario.*;
import com.dam.armario.repositorio.UsuarioBD;


public class ServicioUsuario {


    public void altaUsuario(UsuarioBD listaUsers, String[] datos){
        Usuario usuario = new Usuario(datos[0], datos[1], datos[2], datos[3]);
        listaUsers.altaUsuario(usuario);   
    }

    public void eliminarUsuario(UsuarioBD listaUsers, String[] datos){
        Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
        if (a!=null){
            listaUsers.eliminarUsuario(a);
        }
    }

    public void logInUsuario(UsuarioBD listaUsers,String[] datos){
        Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
        listaUsers.setFalse();
        if(a!=null){
            a.setLogueado(true);
        }
        
    }

    public boolean checkSesion(UsuarioBD listaUsers){
        boolean sesion = false;
        if(listaUsers.buscarSesion()!=null){
            sesion = true;
        }else{
            sesion = false;
        }
        return sesion;
    }

    public Usuario recuperarUsuario(UsuarioBD listaUsers, String recuperar){
        return listaUsers.recuperarContraseña(recuperar);
    }

        

  

}
