package com.dam.armario.servicios;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dam.armario.entidades.outfits.Outfits;
import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;
import com.dam.armario.servicios.interfaz.InterfazGeneral;

public class ServicioOutfit implements InterfazGeneral {
    MenuOutfit menuOutfit = new MenuOutfit();
    ServiciosLogs Logger = new ServiciosLogs();
    public void alta(ArrayList<String> confOutfit, UsuarioBD listaUsuario) {
        Outfits nuevoOutfit = new Outfits();
        Usuario u = listaUsuario.buscarSesion();
        for (int i = 0; i < confOutfit.size() - 1; i++) {
            nuevoOutfit.addPrenda(u.getPrenda(Integer.parseInt(confOutfit.get(i)) - 1));
        }
        nuevoOutfit.setNombreOutfit(confOutfit.get(confOutfit.size() - 1));
        guardarOutfit(nuevoOutfit, listaUsuario);
        insertarOutfitsBBDD(confOutfit, listaUsuario, confOutfit.get(confOutfit.size() - 1));
    }

    public static Map<String, List<Outfits>> agruparOutfitsPorNombre(List<Outfits> listaOutfits) {
        Map<String, List<Outfits>> mapa = new HashMap<>();
        for (Outfits outfit : listaOutfits) {
            String nombre = outfit.getNombreOutfit();  
            if (!mapa.containsKey(nombre)) {
                mapa.put(nombre, new ArrayList<>());
            }
            mapa.get(nombre).add(outfit);
        }
        return mapa;
    }


    public void mostrar(Usuario u) {
        if (u.getOutfitsBD().isEmpty()) {
            menuOutfit.noHayOutfit();
        } else {
            menuOutfit.mostrarOutfits(agruparOutfitsPorNombre(u.getOutfitsBD()));
        }
    }

    public void verOutfit(String numeroOutfit, Usuario u) {
        int index = Integer.parseInt(numeroOutfit);
        if (index >= 1 && index <= u.getOutfitsBD().size()) {
            menuOutfit.imprimirOutfit(u.getOutfitsBD().get(index - 1));
        } else {
            Logger.logError("Error al imprimir outfit");
            menuOutfit.errorOutfit();
        }
    }

    public void guardarOutfit(Outfits oufit, UsuarioBD listaUsuario) {
        listaUsuario.buscarSesion().altaOutfit(oufit);
    }

    public void guardarEnUsuario(Outfits outfit, Usuario usuario){
        usuario.altaOutfit(outfit);
    }
    public void eliminar(Usuario u){
        mostrar(u);
        int numeroOutfit = menuOutfit.eliminarOutfit(u);
        u.removeOutfit(numeroOutfit);
        eliminarOutfitUser(numeroOutfit);
    }

    public void actualizarOutfits(ArrayList<String> confOutfit, Usuario usuario){
        Outfits nuevoOutfit = new Outfits();
        for (int i = 0; i < confOutfit.size() - 1; i++) {
            nuevoOutfit.addPrenda(usuario.getPrenda(Integer.parseInt(confOutfit.get(i)) - 1));
        }
        nuevoOutfit.setNombreOutfit(confOutfit.get(confOutfit.size() - 1));
        guardarEnUsuario(nuevoOutfit, usuario);
    }

    public void escribirDatosUsers(ArrayList<String> datos, UsuarioBD listaUsuario){
        String rutaRopa = Constantes.rutaDocs + listaUsuario.buscarSesion().getNombre() + "\\configOutfits.txt";
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

        public void insertarOutfitsBBDD(ArrayList<String> datos, UsuarioBD listaUsuario, String nombre){
        try {

            // PASO 1: CONECTARSE
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

            // PASO 2: PREPARA LA SQL
            String sql = "INSERT INTO outfits(nombre, configOutfit, usuario_id) VALUES(?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            String dato = "";
            for(String palabra : datos){
                dato = dato + palabra + ";";
            }
            ps.setString(1, nombre);
            ps.setString(2, dato);
            ps.setInt(3, listaUsuario.getUserID());

            // PASO 3: EJECUTA LA SQL
            ps.executeUpdate();

            // PASO 4: DESCONECTARSE

            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void eliminarOutfitUser(int Id_outfit){
        try {

            // PASO 1: CONECTARSE
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

            // PASO 2: PREPARA LA SQL
            String sql = "REMOVE * FROM outfits WHERE id = " + Id_outfit;
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            // PASO 3: EJECUTA LA SQL
            ps.executeUpdate();

            // PASO 4: DESCONECTARSE

            ps.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
