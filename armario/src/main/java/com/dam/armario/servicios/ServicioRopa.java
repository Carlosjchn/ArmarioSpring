package com.dam.armario.servicios;

import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.repositorio.*;
import com.dam.armario.servicios.interfaz.InterfazGeneral;
import com.dam.armario.frontend.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



public class ServicioRopa implements InterfazGeneral {
    MenuRopa menuRopa = new MenuRopa();
    ServiciosLogs Logger = new ServiciosLogs();
    public void alta(ArrayList<String> opcionPrenda, UsuarioBD listaUsuarios) {
        if (Integer.parseInt(opcionPrenda.get(0)) < 8) {
            Ropa nuevaPrenda = crearObjeto(opcionPrenda);
            elegirColor(nuevaPrenda, opcionPrenda);
            elegirTalla(nuevaPrenda, opcionPrenda);
            elegirMarca(nuevaPrenda, opcionPrenda);
            elegirMaterial(nuevaPrenda, opcionPrenda);
            guardarPrenda(nuevaPrenda, listaUsuarios);
            escribirRopaUsers(opcionPrenda, listaUsuarios);
        }
    }

    public Ropa crearObjeto(ArrayList<String> opcionPrenda) {

        switch (opcionPrenda.get(0)) {
            case "1":
                Ropa abrigo = new Abrigo(opcionPrenda.get(5));
                return abrigo;
            case "2":
                Ropa camisa = new Camisa(opcionPrenda.get(5), opcionPrenda.get(6));
                return camisa;
            case "3":
                Ropa camiseta = new Camiseta(opcionPrenda.get(5), opcionPrenda.get(6), opcionPrenda.get(7));
                return camiseta;
            case "4":
                Ropa jersey = new Jerseis(opcionPrenda.get(5), opcionPrenda.get(6));
                return jersey;
            case "5":
                Ropa pantalon = new Pantalon(opcionPrenda.get(5));
                return pantalon;
            case "6":
                Ropa sudadera = new Sudadera(opcionPrenda.get(5), opcionPrenda.get(6));
                return sudadera;
            case "7":
                Ropa zapato = new Zapatos();
                return zapato;
            default:
                return null;
        }

    }

    public void elegirColor(Ropa a, ArrayList<String> opcionPrenda) {
        String color = "";
        switch (opcionPrenda.get(1)) {
            case "1":
                color = "Negro";
                break;
            case "2":
                color = "Blanco";
                break;
            case "3":
                color = "Azul";
                break;
            case "4":
                color = "Rojo";
                break;
            case "5":
                color = "Verde";
                break;
            case "6":
                color = "Multicolor";
                break;
        }
        a.setColor(color);
    }

    public void elegirTalla(Ropa a, ArrayList<String> opcionPrenda) {
        String talla = "";
        if (opcionPrenda.get(0).equals("7")) {
            switch (opcionPrenda.get(2)) {
                case "1":
                    talla = "35-36";
                    break;
                case "2":
                    talla = "37-38";
                    break;
                case "3":
                    talla = "38-39";
                    break;
                case "4":
                    talla = "40-41";
                    break;
                case "5":
                    talla = "41+";
                    break;
            }
        } else {
            switch (opcionPrenda.get(2)) {
                case "1":
                    talla = "XS";
                    break;
                case "2":
                    talla = "S";
                    break;
                case "3":
                    talla = "M";
                    break;
                case "4":
                    talla = "L";
                    break;
                case "5":
                    talla = "XL";
                    break;
            }
        }
        a.setTalla(talla);
    }

    public void elegirMarca(Ropa a, ArrayList<String> opcionPrenda) {
        a.setMarca(opcionPrenda.get(3));
    }

    public void elegirMaterial(Ropa a, ArrayList<String> opcionPrenda) {
        String material = "";
        switch (opcionPrenda.get(4)) {
            case "1":
                material = "Algodón";
                break;
            case "2":
                material = "Pana";
                break;
            case "3":
                material = "Nilon";
                break;
            case "4":
                material = "Poliester";
                break;
            case "5":
                material = "Cuero";
                break;
        }
        a.setMaterial(material);
    }

    public void guardarPrenda(Ropa prenda, UsuarioBD listaUsuario) {
        listaUsuario.buscarSesion().altaRopa(prenda);
    }

    public void guardarEnUsuario(Ropa prenda, Usuario usuario) {
        usuario.altaRopa(prenda);
    }

    public void mostrar(Usuario u) {
        if (u.getRopaBD().isEmpty()) {
            menuRopa.noHayPrendas();
        } else {
            int iteraciones = 0;
            menuRopa.tuRopa();
            for (Ropa prenda : u.getRopaBD()) {
                iteraciones++;
                menuRopa.imprimirPrenda(prenda, iteraciones);
            }
        }
    }

    public void eliminar(Usuario u){
        mostrar(u);
        int numeroRopa = menuRopa.eliminarRopa(u);
        u.removePrendaIndex(numeroRopa);
    }

    public void actualizarRopas(ArrayList<String> opcionPrenda, Usuario Usuario) {
        if (Integer.parseInt(opcionPrenda.get(0)) < 8) {
            Ropa nuevaPrenda = crearObjeto(opcionPrenda);
            elegirColor(nuevaPrenda, opcionPrenda);
            elegirTalla(nuevaPrenda, opcionPrenda);
            elegirMarca(nuevaPrenda, opcionPrenda);
            elegirMaterial(nuevaPrenda, opcionPrenda);
            guardarEnUsuario(nuevaPrenda, Usuario);
        }
    }
   
    public void escribirRopaUsers(ArrayList<String> datos, UsuarioBD listaUsuario){
        String rutaRopa = Constantes.rutaDocs + listaUsuario.buscarSesion().getNombre() + "\\ropa.txt";
        try (FileWriter escritor = new FileWriter(rutaRopa, true)) {
            for (String dato : datos) {
                escritor.write(dato + ";");
            }
            escritor.write("\n");
        } catch (IOException e) {
            Logger.logError(e.getMessage());
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
