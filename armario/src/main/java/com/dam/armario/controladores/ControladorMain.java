package com.dam.armario.controladores;

import com.dam.armario.servicios.*;

import java.util.*;
import com.dam.armario.entidades.usuario.*;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;

public class ControladorMain {
    UsuarioBD listaUsuarios = new UsuarioBD(); // "Base de datos de usuarios"

    MenuInicio menuInicio = new MenuInicio(); // "Sysos y Scanners"
    MenuPrincipal menuP = new MenuPrincipal();
    MenuRopa menuRopa = new MenuRopa();
    MenuOutfit menuOutfit = new MenuOutfit();
    MenuUsuario menuUsuario = new MenuUsuario();
    MenuTienda menuTienda = new MenuTienda();

    ServicioUsuario funcionesUser = new ServicioUsuario(); // Servicios de los objetos
    ServicioRopa funcionesRopa = new ServicioRopa();
    ServicioOutfit funcionesOutfit = new ServicioOutfit();
    ServicioTienda funcionesTienda = new ServicioTienda();
    ServiciosLogs Logger = new ServiciosLogs();


    public void inicio() {
        //File datosUsuarios = new File(Constantes.rutaDocs + "Usuarios.txt");
        // listaUsuarios.inicializadorDatos(datosUsuarios);
        listaUsuarios.inicializadorUsersBBDD();
        boolean inicio = true;
        while (inicio == true) {
            do {
                String opcion = menuInicio.registro();
                Logger.logInfo("Entrando en el menu Incial de la app.");
                switch (opcion) {
                    case "1": // registrar usuario

                        ArrayList<String> datos = menuInicio.datosRegistro();
                        funcionesUser.alta(datos, listaUsuarios);
                        Logger.logInfo("Registrando usuario...");

                        break;
                    case "2": // iniciar sesion

                        String datosLogin[] = menuInicio.datosLogin();
                        Logger.logInfo("Iniicando de registro usuario.");

                        if(funcionesUser.logInUsuario(listaUsuarios, datosLogin)==true){

                            menuInicio.loginCorrecto();
                            Logger.logInfo("Usuario" + listaUsuarios.buscarSesion() +"registrado correctamente.");

                        }
                        break;
                    case "3": // recuperar usuario

                        String recuperar = menuInicio.datosRecuperar();
                        Usuario userRecuperar = funcionesUser.recuperarUsuario(listaUsuarios, recuperar);
                        Logger.logInfo("Iniciando recuperacion de usuario.");

                        if (userRecuperar != null) {
                            menuInicio.recuperarContraseña(userRecuperar);
                            Logger.logInfo("Contraseña de " + userRecuperar.getNombre() + "recuperada.");
                        } else {
                            menuInicio.errorRecuperar();
                        }
                        
                        break;
                    case "4": // salir programa ARREGLAR

                        listaUsuarios.cerrarSesion();
                        menuInicio.salirApp();
                        Logger.logInfo("Cerrando aplicacion.");

                        inicio = false;
                        break;
                }

            } while (funcionesUser.checkSesion(listaUsuarios) == false);

            while (funcionesUser.checkSesion(listaUsuarios) == true) {

                String opcion = menuP.principal();
                Logger.logInfo("Usuario" + listaUsuarios.buscarSesion() + "Entra en Menu Principal.");
                switch (opcion) {
                    case "1": // Ropa

                        opcion = menuRopa.ropa();
                        Logger.logInfo("Entrando en el menu de Ropa del usuario" + listaUsuarios.buscarSesion());

                        switch (opcion) {
                            case "1": // ver Ropa

                                funcionesRopa.mostrar(listaUsuarios.buscarSesion());
                                Logger.logInfo("Viendo la ropa del usuario " + listaUsuarios.buscarSesion());

                                break;
                            case "2": // añadir Prenda
                                
                                ArrayList<String> configPrenda = menuRopa.menuAñadirPrenda();
                                funcionesRopa.alta(configPrenda, listaUsuarios);
                                Logger.logInfo("Añadiendo prenda al usuario " + listaUsuarios.buscarSesion());

                                break;
                            case "3": // eliminar Prenda
                                funcionesRopa.eliminar(listaUsuarios.buscarSesion());
                                Logger.logInfo( "Eliminando prenda del usuario " + listaUsuarios.buscarSesion());
                                break;
                            default: break;
                        }
                        break;
                    case "2": // Outfits
                        opcion = menuOutfit.outfit();
                        Logger.logInfo("Entrando en el menu de Outfits del usuario " + listaUsuarios.buscarSesion());
                        switch (opcion) {
                            case "1": // ver outfits
                                Usuario usuarioLogueado = listaUsuarios.buscarSesion();
                                funcionesOutfit.mostrar(usuarioLogueado);
                                Logger.logInfo("Viendo outfits del usuario" + listaUsuarios.buscarSesion());
                                // if (listaUsuarios.buscarSesion().getOutfitsBD().size() > 0) {
                                //     String numeroOutfit = menuOutfit.elegirOutfit();
                                //     funcionesOutfit.verOutfit(numeroOutfit, usuarioLogueado);
                                // }
                                break;
                            case "2": // crear outfit
                                ArrayList<String> configOutfit = menuOutfit.crearOutfit(listaUsuarios);
                                funcionesOutfit.alta(configOutfit, listaUsuarios);
                                Logger.logInfo("Creando outfit al usuario " + listaUsuarios.buscarSesion());
                                break;
                            case "3": //eliminar outfit
                                funcionesOutfit.eliminar(listaUsuarios.buscarSesion());
                                Logger.logInfo( "Eliminando outfit del usuario " + listaUsuarios.buscarSesion());
                                break;
                            default: break;
                        }
                        break;
                    // case "3": // Tienda
                    //     opcion = menuTienda.Tienda(listaUsuarios);
                    //     Logger.logInfo("Entrando en el menu de Tienda del usuario " + listaUsuarios.buscarSesion());
                    //     switch(opcion){
                    //         case "1": // ver productos
                    //         funcionesTienda.comprarPrenda(listaUsuarios);
                    //         Logger.logInfo("Usuario " + listaUsuarios.buscarSesion() + " viendo productos a la venta");;
                    //         break;
                    //         case "2": // ver tienda personal
                    //         funcionesTienda.tiendaPersonal(listaUsuarios);
                    //         Logger.logInfo("Usuario " + listaUsuarios.buscarSesion() + " viendo su tienda personal");
                    //         break;
                    //         default: break;
                    //     }
                    //     break;
                    case "3": // Perfil
                        funcionesUser.modificarPerfil(listaUsuarios.buscarSesion());
                        Logger.logInfo("Usuario " + listaUsuarios.buscarSesion() + " entra en menu de Perfil personal.");
                        break;
                    case "4": // Cerrar sesion.
                        listaUsuarios.cerrarSesion();
                        Logger.logInfo("Usuario " + listaUsuarios.buscarSesion() + " Ha cerrado sesión.");
                        menuP.cerrarApp();
                        break;
                }

            }
        }
    }
}
