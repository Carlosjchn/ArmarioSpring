package com.dam.armario.servicios;
import com.dam.armario.entidades.usuario.*;

import com.dam.armario.entidades.usuario.*;
import com.dam.armario.repositorio.*;

public class ServicioUsuario {

    UsuarioBD listaUsers= new UsuarioBD();
    public void altaUsuario(String nombre, String email, String password, String recuperar){
        Usuario usuario = new Usuario(nombre, email, password, recuperar);
        listaUsers.altaUsuario(usuario);   
    }
    public void eliminarUsuario(String nombre, String contraseña){

    }
    public void modificarUsuario(String nombre){
        
    }


  

}
