package com.dam.armario.repositorio;

import java.util.ArrayList;

import com.dam.armario.entidades.usuario.*;
// ENVIAR LA BASE DE DATOS A CADA CONTROLADOR PARA QUE SE ACTUALIZE.
public class UsuarioBD{
    ArrayList<Usuario> usuarioBD = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarioBD() {
        return usuarioBD;
    }

    public void altaUsuario(Usuario u) {
        usuarioBD.add(u);
    }

    public void eliminarUsuario(Usuario u) {
        usuarioBD.remove(u);
    }

    public Usuario buscarUsuario(String nombre, String contraseña) {
        for (Usuario u : usuarioBD) {
            if (nombre.equals(u.getNombre()) && contraseña.equals(u.getPassword())) {
               return u;
            }
        }
        return null;
    }

    public void setFalse(){
        for(Usuario u : usuarioBD){
            u.setLogueado(false);
        }
    }

    public Usuario buscarSesion(){
        for(Usuario u : usuarioBD){
            if(u.isLogueado()==true){
                return u;
            }
        }
        return null;
    }

    public Usuario recuperarContraseña(String recuperar) {
        for (Usuario u : usuarioBD){
            if(recuperar.equals(u.getRecuperar())){
                return u;
            }
        }
        return null;
    }
    
    public void cerrarSesion(){
        for(Usuario u : usuarioBD){
            u.setLogueado(false);
        }
    }

}
