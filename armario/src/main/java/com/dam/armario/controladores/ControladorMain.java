package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;

import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;

public class ControladorMain {
    UsuarioBD listaUsuarios = new UsuarioBD();
    ServicioUsuario funcionesUser = new ServicioUsuario();
    Menus menus = new Menus();
    
    Scanner sc = new Scanner(System.in);
    
    public void inicio() {
        
        do{
            String opcion = menus.registro();
            
           switch(opcion){
            case "1":
                funcionesUser.altaUsuario(listaUsuarios,menus.datosRegistro());
                break;
            case "2":
                funcionesUser.logInUsuario(listaUsuarios, menus.datosLogin());
                break;
            case "3":
                String recuperar = menus.datosRecuperar();
                if(funcionesUser.recuperarUsuario(listaUsuarios, recuperar )!=null){
                    menus.recuperarContraseña(funcionesUser.recuperarUsuario(listaUsuarios,recuperar));
                }else{
                    menus.errorRecuperar();
                }
                    break;
            case "4":
                listaUsuarios.cerrarSesion();
                menus.cerrarSesion();
                break;
           };
           
        }while(funcionesUser.checkSesion(listaUsuarios) == false);
       
        do{
            System.out.println("Bienvenido");
        }while(funcionesUser.checkSesion(listaUsuarios) == true);
    }
}
