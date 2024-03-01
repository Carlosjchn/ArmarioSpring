package com.dam.armario.servicios;

import java.util.ArrayList;

import com.dam.armario.entidades.outfits.Outfits;

import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;
import com.dam.armario.servicios.interfaz.InterfazGeneral;

public class ServicioOutfit implements InterfazGeneral {
    MenuOutfit menuOutfit = new MenuOutfit();

    public void alta(ArrayList<String> opcionOutfit, UsuarioBD listaUsuario) {
        Outfits nuevoOutfit = new Outfits();
        Usuario u = listaUsuario.buscarSesion();
        for (int i = 0; i < opcionOutfit.size() - 1; i++) {
            nuevoOutfit.addPrenda(u.getPrenda(Integer.parseInt(opcionOutfit.get(i)) - 1));
        }
        nuevoOutfit.setNombreOutfit(opcionOutfit.get(opcionOutfit.size() - 1));
        u.altaOutfit(nuevoOutfit);
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

    public void mostrarAlaVenta(Usuario u) {
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

    public void eliminar(Usuario u){
        mostrar(u);
        int numeroOutfit = menuOutfit.eliminarOutfit(u);
        u.removeOutfit(numeroOutfit);
    }
}
