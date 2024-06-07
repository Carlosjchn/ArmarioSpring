package com.dam.armario.servicios;

import com.dam.armario.entidades.usuario.*;
import com.dam.armario.excepciones.ExcepcionPass;
import com.dam.armario.excepciones.LoginExcepcion;
import com.dam.armario.frontend.MenuUsuario;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.interfaz.InterfazGeneral;


import java.io.*;
import java.sql.*;
import java.util.*;

public class ServicioUsuario implements InterfazGeneral {
    MenuUsuario menuUsuario = new MenuUsuario();
    ServiciosLogs Logger = new ServiciosLogs();
   
    public void alta(ArrayList<String> datos, UsuarioBD listaUsers) {
        Usuario usuario = new Usuario(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
        // escribirDatosUsers(datos);
        // generarCarpetaUser(datos);
        listaUsers.altaUsuario(usuario);
        insertarDatosUser(datos);
    }

    public void eliminarUsuario(UsuarioBD listaUsers, String[] datos) {
        try {
            Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
            listaUsers.eliminarUsuario(a);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean logInUsuario(UsuarioBD listaUsers, String[] datos) {

        try {
            Usuario a = listaUsers.buscarUsuario(datos[0], datos[1]);
            listaUsers.setFalse();
            a.setLogueado(true);
            return true;
        } catch (LoginExcepcion e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    public boolean checkSesion(UsuarioBD listaUsers) {
        if (listaUsers.buscarSesion() != null) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario recuperarUsuario(UsuarioBD listaUsers, String recuperar) {
        return listaUsers.recuperarContraseña(recuperar);
    }

    public void mostrar(Usuario u) {
        menuUsuario.verPerfil(u);
    }

    public void modificarPerfil(Usuario u) {
        mostrar(u);
        String opcion = menuUsuario.modificarPerfil(u);
        try {
            String cambio = menuUsuario.datosModificar(opcion);
            u.modificarPerfilBBDD(u, opcion, cambio);
            switch (opcion) {
                case "1": // Cambiar nombre de usuario

                    u.setNombre(menuUsuario.datosModificar(opcion));
                    break;
                case "2": // Cambiar email
                    u.setEmail(menuUsuario.datosModificar(opcion));
                    break;
                case "3": // Cambiar contraseña
                    u.setPassword(menuUsuario.datosModificar(opcion));
                    break;
                case "4": // Añadir saldo
                    u.añadirSaldo(menuUsuario.datosModificar(opcion));
                    break;
                default:
                    break;
            }
            if (opcion.equals("1") || opcion.equals("2") || opcion.equals("3") || opcion.equals("4")) {
                menuUsuario.checkPass(u);
            }
        } catch (ExcepcionPass e) {

        }
    }

    
    public void eliminar(Usuario u) {

    }

    public void generarCarpetaUser(ArrayList<String> datos) {
        String rutaCarpeta = Constantes.rutaDocs + datos.get(0);

        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            boolean creacionExitosa = carpeta.mkdirs();
            if (creacionExitosa) {
                File ropaUser = new File(rutaCarpeta + "\\ropa.txt");
                File configOutfits = new File(rutaCarpeta + "\\configOutfits.txt");
                try {
                    ropaUser.createNewFile();
                    configOutfits.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
        } else {
            System.out.println("La carpeta ya existe.");
        }
    }

    public void escribirDatosUsers(ArrayList<String> datos) {
        try (FileWriter escritor = new FileWriter(Constantes.rutaDocs + "Usuarios.txt", true)) {
            for (String dato : datos) {
                escritor.write(dato + ";");
            }
            escritor.write("\n");
        } catch (IOException e) {
            Logger.logError(e.getMessage());
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void insertarDatosUser(ArrayList<String> datos) {
        try {

            // PASO 1: CONECTARSE
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

            // PASO 2: PREPARA LA SQL
            String sql = "INSERT INTO usuarios(nombre, correo, contrasena, seguridad, saldo) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, datos.get(0));
            ps.setString(2, datos.get(1));
            ps.setString(3, datos.get(2));
            ps.setString(4, datos.get(3));
            ps.setDouble(5, 100);

            // PASO 3: EJECUTA LA SQL
            ps.executeUpdate();

            // PASO 4: DESCONECTARSE

            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String limpiarCorreo(String correo) {
        int indiceArroba = correo.indexOf('@');
        if (indiceArroba != -1) {
            return correo.substring(0, indiceArroba);
        }
        return correo;
    }
}
