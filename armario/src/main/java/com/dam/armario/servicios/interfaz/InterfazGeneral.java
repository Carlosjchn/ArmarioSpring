package com.dam.armario.servicios.interfaz;

import java.util.ArrayList;

import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.repositorio.UsuarioBD;

public interface InterfazGeneral {
    public void alta(ArrayList<String> opcionPrenda, UsuarioBD listaUsuarios);
    public void mostrar(Usuario u);
}
