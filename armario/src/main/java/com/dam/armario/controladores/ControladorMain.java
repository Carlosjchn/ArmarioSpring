package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;
import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.usuario.*;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;

public class ControladorMain {
    UsuarioBD listaUsuarios = new UsuarioBD(); // "Base de datos de usuarios"

    MenuInicio menuInicio = new MenuInicio(); // "Sysos y Scanners"
    MenuPrincipal menuP = new MenuPrincipal();
    MenuRopa menuRopa = new MenuRopa();
    MenuOutfit menuOutfit = new MenuOutfit();

    ServicioUsuario funcionesUser = new ServicioUsuario(); // Servicios de los objetos
    ServicioRopa funcionesRopa = new ServicioRopa();
    ServicioOutfit funcionesOutfit = new ServicioOutfit();

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
                        opcion = menuRopa.ropa();
                        switch (opcion) {
                            case "1": // ver Ropa
                                funcionesRopa.mostrar(listaUsuarios.buscarSesion());
                                break;
                            case "2": // añadir Prenda
                                ArrayList<String> configPrenda = menuRopa.menuAñadirPrenda();
                                funcionesRopa.crear(configPrenda,listaUsuarios);
                                break;
                        }
                        break;
                    case "2": // Outfits
                        opcion = menuOutfit.outfit();
                        switch(opcion){
                            case "1": // ver outfits
                                funcionesOutfit.mostrar(listaUsuarios.buscarSesion());
                                //Falta otro metodo para imprimir cada outfit.
                                break;
                            case "2": // crear outfit
                                ArrayList<String> configOutfit = menuOutfit.crearOutfit(listaUsuarios);
                                funcionesOutfit.crear(configOutfit, listaUsuarios);
                                break;
                        }
                        break;
                    case "3": // Tienda

                        break;
                    case "4": // Perfil
                        
                        break;
                    case "5": // Cerrar sesion.
                        listaUsuarios.cerrarSesion();
                        System.out.println("Cerrando sesion...");
                        break;
                }

            }
        }
    }
}
