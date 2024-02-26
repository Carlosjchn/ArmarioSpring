package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;
import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.usuario.*;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;

public class ControladorMain {
    UsuarioBD listaUsuarios = new UsuarioBD();
    ServicioUsuario funcionesUser = new ServicioUsuario();
    MenuInicio menuInicio = new MenuInicio();
    MenuPrincipal menuP = new MenuPrincipal();
    MenuRopa menuRopa = new MenuRopa();

    Scanner sc = new Scanner(System.in);

    public void inicio() {
        boolean inicio = true;
        while (inicio == true) {
            do {
                String opcion = menuInicio.registro();
                switch (opcion) {
                    case "1": // registrar usuario
                        funcionesUser.altaUsuario(listaUsuarios, menuInicio.datosRegistro());
                        break;
                    case "2": // iniciar sesion
                        funcionesUser.logInUsuario(listaUsuarios, menuInicio.datosLogin());
                        break;
                    case "3": // recuperar usuario
                        String recuperar = menuInicio.datosRecuperar();
                        Usuario userRecuperar = funcionesUser.recuperarUsuario(listaUsuarios, recuperar);
                        if (userRecuperar != null) {
                            menuInicio.recuperarContraseña(userRecuperar);
                        } else {
                            menuInicio.errorRecuperar();
                        }
                        break;
                    case "4": // salir programa ARREGLAR
                        listaUsuarios.cerrarSesion();
                        menuInicio.salirApp();
                        inicio = false; 
                        break;
                }

            } while (funcionesUser.checkSesion(listaUsuarios) == false);

            while (funcionesUser.checkSesion(listaUsuarios) == true) {

                String opcion = menuP.principal();
                switch (opcion) {
                    case "1": // Ropa
                    
                    case "2": // Outfits

                    case "3": // Tienda

                    case "4": // Perfil

                    case "5": // Cerrar sesion.
                        listaUsuarios.cerrarSesion();
                        System.out.println("Cerrando sesion...");
                }

            }
        }
    }
}
