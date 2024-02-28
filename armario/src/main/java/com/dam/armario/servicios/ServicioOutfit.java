package com.dam.armario.servicios;

import java.util.ArrayList;

import com.dam.armario.entidades.outfits.Outfits;

import com.dam.armario.entidades.ropa.Ropa;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.frontend.*;
import com.dam.armario.repositorio.*;
import com.dam.armario.servicios.interfaz.InterfazGeneral;

public class ServicioOutfit implements InterfazGeneral {
    MenuOutfit menuOutfit = new MenuOutfit();

    public void crear(ArrayList<String> opcionOutfit, UsuarioBD listaUsuario) {
        Outfits nuevoOutfit = new Outfits();
        Usuario u = listaUsuario.buscarSesion();
        for (int i=0; i < opcionOutfit.size() - 1; i++) {
            nuevoOutfit.addPrenda(u.getRopaBD().get(Integer.parseInt(opcionOutfit.get(i))));
        }
        nuevoOutfit.setNombreOutfit(opcionOutfit.get(opcionOutfit.size()-1));
        u.altaOutfit(nuevoOutfit);
    }

    public void mostrar(Usuario u) {
        if (u.getOutfitsBD().isEmpty()) {
            menuOutfit.noHayOutfit();
        } else {
            int iteraciones = 0;
            for (Outfits outfit : u.getOutfitsBD()) {
                iteraciones++;
                menuOutfit.imprimirOutfit(outfit, iteraciones);
            }
        }
    }

    public void verOutfit(int index, Usuario u) {
        if (index >= 1 || index < u.getOutfitsBD().size()) {
            System.out.println(u.getOutfitsBD().get(index - 1));
        }
    }

    public void guardarOutfit(Outfits oufit, UsuarioBD listaUsuario) {
        listaUsuario.buscarSesion().altaOutfit(oufit);
    }
}
