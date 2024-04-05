package com.dam.armario.repositorio;

import java.io.*;
import java.util.*;

import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.*;
import com.dam.armario.excepciones.*;
import com.dam.armario.servicios.*;

// ENVIAR LA BASE DE DATOS A CADA CONTROLADOR PARA QUE SE ACTUALIZE.
public class UsuarioBD {
    private ArrayList<Usuario> usuarioBD = new ArrayList<Usuario>();

    ServicioUsuario funcionesUser = new ServicioUsuario(); // Servicios de los objetos
    ServicioRopa funcionesRopa = new ServicioRopa();
    ServicioOutfit funcionesOutfit = new ServicioOutfit();
    ServicioTienda funcionesTienda = new ServicioTienda();

    public ArrayList<Usuario> getUsuarioBD() {
        return usuarioBD;
    }

    public void altaUsuario(Usuario u) {
        usuarioBD.add(u);
    }

    public void eliminarUsuario(Usuario u) {
        usuarioBD.remove(u);
    }

    public Usuario buscarUsuario(String nombre, String contraseña) throws LoginExcepcion {
        for (Usuario u : usuarioBD) {
            if (nombre.equalsIgnoreCase(u.getNombre()) && contraseña.equals(u.getPassword())) {
                return u;
            }
        }
        throw new LoginExcepcion();
    }

    public Usuario buscarNombre(String nombre) throws NombreExcepcion {
        for (Usuario u : usuarioBD) {
            if (nombre.equalsIgnoreCase(u.getNombre())) {
                return u;
            }
        }
        throw new NombreExcepcion();
    }

    public void setFalse() {
        for (Usuario u : usuarioBD) {
            u.setLogueado(false);
        }
    }

    public Usuario buscarSesion() {
        for (Usuario u : usuarioBD) {
            if (u.isLogueado() == true) {
                return u;
            }
        }
        return null;
    }

    public Usuario recuperarContraseña(String recuperar) {
        for (Usuario u : usuarioBD) {
            if (recuperar.equals(u.getRecuperar())) {
                return u;
            }
        }
        return null;
    }

    public void cerrarSesion() {
        buscarSesion().setLogueado(false);
    }

    public ArrayList<Usuario> getVendedores() {
        ArrayList<Usuario> vendedores = new ArrayList<>();
        for (Usuario u : usuarioBD) {
            if (u.isLogueado() == false) {
                vendedores.add(u);
            }
        }
        return vendedores;
    }

    public void comprarPrenda(Usuario vendedor, Ropa Prenda) throws SaldoExcepcion {
        Usuario comprador = buscarSesion();
        try {
            if (comprador.getSaldo() - Prenda.getPrecio() >= 0) {
                comprador.setSaldo(comprador.getSaldo() - Prenda.getPrecio());
                vendedor.setSaldo(vendedor.getSaldo() + Prenda.getPrecio());
                vendedor.removePrenda(Prenda);
                Prenda.setPrecio(0);
                comprador.altaRopa(Prenda);
                updateUsuario(comprador);
                updateUsuario(vendedor);
            } else {
                throw new SaldoExcepcion();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUsuario(Usuario u) {
        for (int i = 0; i < usuarioBD.size(); i++) {
            if (usuarioBD.get(i).getNombre().equals(u.getNombre())) {
                usuarioBD.set(i, u);
            }
        }
    }

    // actualizar array base de datos con todos los usuarios
    public void inicializadorDatos(File usuarios) {

        try {
            FileReader fr = new FileReader(usuarios);
            try (BufferedReader lector = new BufferedReader(fr)) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datosUsuario = linea.split(";");
                    Usuario usuario = new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3]);
                    usuario = actualizarUsuario(datosUsuario[0], usuario);
                    altaUsuario(usuario);
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Usuario actualizarUsuario(String nombreUsuario, Usuario usuario) {
        String ropaPath = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\docs\\"
                + nombreUsuario + "\\ropa.txt";
        String outfitPath = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\docs\\" + nombreUsuario
                + "\\configOutfits.txt";

        File Ropas = new File(ropaPath);
        File Outfits = new File(outfitPath);
        try {
            FileReader frRopa = new FileReader(Ropas);
            FileReader frOutfit = new FileReader(Outfits);

            if (Ropas.exists() && Outfits.exists()) {

                try (BufferedReader lector1 = new BufferedReader(frRopa)) {
                    String lineaPrenda;
                    while ((lineaPrenda = lector1.readLine()) != null) {
                        String[] configPrenda = lineaPrenda.split(";");
                        ArrayList<String> confPrenda = arrayToList(configPrenda);
                        funcionesRopa.actualizarRopas(confPrenda, usuario);
                    }
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                }

                try (BufferedReader lector2 = new BufferedReader(frOutfit)) {
                    String lineaOutfit;
                    while ((lineaOutfit = lector2.readLine()) != null) {
                        String[] configOutfit = lineaOutfit.split(";");
                        ArrayList<String> confOutfit = arrayToList(configOutfit);
                        funcionesOutfit.actualizarOutfits(confOutfit, usuario);
                    }
                } catch (IOException e) {
                    System.err.println("Error al leer el archivo: " + e.getMessage());
                }
                return usuario;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static ArrayList<String> arrayToList(String[] array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String elemento : array) {
            arrayList.add(elemento);
        }
        return arrayList;
    }
}
