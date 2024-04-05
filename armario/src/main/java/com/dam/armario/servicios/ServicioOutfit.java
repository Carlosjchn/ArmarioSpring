package com.dam.armario.servicios;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.dam.armario.entidades.outfits.Outfits;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;
import com.dam.armario.servicios.interfaz.InterfazGeneral;

public class ServicioOutfit implements InterfazGeneral {
    MenuOutfit menuOutfit = new MenuOutfit();

    public void alta(ArrayList<String> confOutfit, UsuarioBD listaUsuario) {
        Outfits nuevoOutfit = new Outfits();
        Usuario u = listaUsuario.buscarSesion();
        for (int i = 0; i < confOutfit.size() - 1; i++) {
            nuevoOutfit.addPrenda(u.getPrenda(Integer.parseInt(confOutfit.get(i)) - 1));
        }
        nuevoOutfit.setNombreOutfit(confOutfit.get(confOutfit.size() - 1));
        guardarOutfit(nuevoOutfit, listaUsuario);
        escribirDatosUsers(confOutfit, listaUsuario);
    }

    public void mostrar(Usuario u) {
        if (u.getOutfitsBD().isEmpty()) {
            menuOutfit.noHayOutfit();
        } else {
            int iteraciones = 0;
            for (Outfits outfit : u.getOutfitsBD()) {
                iteraciones++;
                menuOutfit.listaOufits(outfit, iteraciones);
            }
        }
    }

    public void verOutfit(String numeroOutfit, Usuario u) {
        int index = Integer.parseInt(numeroOutfit);
        if (index >= 1 && index <= u.getOutfitsBD().size()) {
            menuOutfit.imprimirOutfit(u.getOutfitsBD().get(index - 1));
        } else {
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
        String rutaRopa = "armario\\src\\main\\java\\com\\dam\\armario\\repositorio\\docs\\" + listaUsuario.buscarSesion().getNombre() + "\\configOutfits.txt";
        try (FileWriter escritor = new FileWriter(rutaRopa, true)) {
            for (String dato : datos) {
                escritor.write(dato + ";");
            }
            escritor.write("\n");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
