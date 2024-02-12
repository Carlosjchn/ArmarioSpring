package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;
public class ControladorUsuario {
    Scanner sc = new Scanner(System.in);

    public void menuUser(){
        ServicioUsuario usuario=new ServicioUsuario();
        System.out.println("\t 1. Registrarse \n\t 2. Iniciar Sesión \n\t 3. Recuperar cotraseña \n\t 4. Salir ");
        String opcion;
        do{
        opcion = sc.next();
        switch (opcion){
            case "1":
            break;
            case "2":
            break;
            case "3":
            break;
            case "4":
            break;
            default:System.out.println("Elige una opcion válida.");
        }
    }while(Integer.parseInt(opcion)<1 && Integer.parseInt(opcion)>4);
    }
}
