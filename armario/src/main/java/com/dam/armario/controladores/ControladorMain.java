package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;

import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;

public class ControladorMain {
    UsuarioBD listaUsuarios = new UsuarioBD();
    ServicioUsuario funcionesUser = new ServicioUsuario();
    MenuInicio menuInicio = new MenuInicio();

    Scanner sc = new Scanner(System.in);

    public void inicio() {
        boolean inicio = true;
        do {
            String opcion = menuInicio.registro();

            switch (opcion) {
                case "1":
                    funcionesUser.altaUsuario(listaUsuarios, menuInicio.datosRegistro());
                    break;
                case "2":
                    funcionesUser.logInUsuario(listaUsuarios, menuInicio.datosLogin());
                    break;
                case "3":
                    String recuperar = menuInicio.datosRecuperar();
                    if (funcionesUser.recuperarUsuario(listaUsuarios, recuperar) != null) {
                        menuInicio.recuperarContraseña(funcionesUser.recuperarUsuario(listaUsuarios, recuperar));
                    } else {
                        menuInicio.errorRecuperar();
                    }
                    break;
                case "4":
                    listaUsuarios.cerrarSesion();
                    menuInicio.cerrarSesion();
                    inicio = false;
                    break;
            }
            ;

        } while (funcionesUser.checkSesion(listaUsuarios) == false && inicio == true);

        while (funcionesUser.checkSesion(listaUsuarios) == true && inicio == true){
            
            
            System.out.println("Bienvenido");
        }
    }
}
