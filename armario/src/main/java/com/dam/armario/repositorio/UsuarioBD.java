package com.dam.armario.repositorio;

import java.io.*;
import java.sql.*;
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
    ServiciosLogs Logger = new ServiciosLogs();

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
                moverLinea(vendedor.getNombre() + "\\ropa.txt", comprador.getNombre() + "ropa.txt ",
                        vendedor.getRopaBD().indexOf(Prenda));
                Logger.logInfo("Se ha realizado una compra con éxito entre " + comprador.getNombre() + " y "
                        + vendedor.getNombre());
            } else {
                Logger.logInfo(comprador.getNombre() + "No tiene suficiente saldo.");
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

    public void inicializadorUsersBBDD() {
        try {

            // PASO 1: CONECTARSE
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

            // PASO 2: PREPARA LA SQL
            String sql = "SELECT * FROM usuarios ";
            PreparedStatement ps = conexion.prepareStatement(sql);

            // PASO 3: EJECUTA LA SQL
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArrayList<String> datosUsuario = new ArrayList<String>();
                datosUsuario.add(rs.getString("nombre"));
                datosUsuario.add(rs.getString("correo"));
                datosUsuario.add(rs.getString("contrasena"));
                datosUsuario.add(rs.getString("seguridad"));
                
                Usuario usuario = new Usuario(datosUsuario.get(0), datosUsuario.get(1), datosUsuario.get(2),
                        datosUsuario.get(3));
                usuario.setId(rs.getInt("id"));
                usuario = actualizarUsuarioBBDD(usuario);
                altaUsuario(usuario);
            }

            // PASO 4: DESCONECTARSE
            rs.close();
            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Usuario actualizarUsuarioBBDD(Usuario usuario) {
        try {
			
			// PASO 1: CONECTARSE
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

			
			// PASO 2: PREPARA LA SQL
			String sql = "SELECT * FROM ropa WHERE  usuario_id = " + usuario.getId();
			PreparedStatement ps = conexion.prepareStatement(sql);
			
			// PASO 3: EJECUTA LA SQL
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                String[] configPrenda = rs.getString("configPrenda").split(";");
                ArrayList<String> confPrenda = arrayToList(configPrenda);
                funcionesRopa.actualizarRopas(confPrenda, usuario);
            }
            
            sql = "SELECT * FROM outfits WHERE  usuario_id = " + usuario.getId();
			ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            String[] configOutfit = rs.getString("configOutfit").split(";");
            ArrayList<String> confOutfit = arrayToList(configOutfit);
            funcionesOutfit.actualizarOutfits(confOutfit, usuario);
            }
            // PASO 4: DESCONECTARSE
            rs.close();
			ps.close();
			conexion.close();
        return usuario;
		} catch (Exception e) {
			System.out.println(e);
            return null;
		}
    }


    public void inicializadorDatos(File usuarios) {

        try {
            FileReader fr = new FileReader(usuarios);
            BufferedReader lector = new BufferedReader(fr);
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datosUsuario = linea.split(";");
                Usuario usuario = new Usuario(datosUsuario[0], datosUsuario[1], datosUsuario[2], datosUsuario[3]);
                usuario = actualizarUsuario(usuario);
                altaUsuario(usuario);
            }
            lector.close();
        } catch (Exception e) {
            Logger.logError("Problema inicializando los datos guardados.");
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Usuario actualizarUsuario(Usuario usuario) {
        String ropaPath = Constantes.rutaDocs + usuario.getNombre() + "\\ropa.txt";
        String outfitPath = Constantes.rutaDocs + usuario.getNombre() + "\\configOutfits.txt";

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
                    Logger.logError("Problema leyendo ropa del archivo.");
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
                    Logger.logError("Problema leyendo outfits del archivo.");
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

    public static void moverLinea(String sourceFile, String destinationFile, int lineToRemove) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(Constantes.rutaDocs + sourceFile));
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(Constantes.rutaDocs + destinationFile, true))) {

            int lineNumber = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (lineNumber != lineToRemove) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }

    public int getUserID(){
        try {

            // PASO 1: CONECTARSE
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

            // PASO 2: PREPARA LA SQL
            String sql = "SELECT id FROM usuarios WHERE nombre = ? ";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, buscarSesion().getNombre());

            // PASO 3: EJECUTA LA SQL
            ResultSet rs = ps.executeQuery();
            int id_User = 0;
            while(rs.next()){
            id_User = rs.getInt("id");
            }
            // PASO 4: DESCONECTARSE
            rs.close();
            ps.close();
            conexion.close();

            return id_User;

        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
}
