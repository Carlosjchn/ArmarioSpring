package com.dam.armario.repositorio;

import java.util.ArrayList;
import com.dam.armario.entidades.usuario.*;

public class UsuarioBD {
    ArrayList<Usuario> UsuarioBD = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuarioBD() {
        return UsuarioBD;
    }

    public void setUsuarioBD(ArrayList<Usuario> usuarioBD) {
        UsuarioBD = usuarioBD;
    }

    public void altaUsuario(Usuario u) {
        UsuarioBD.add(u);
    }

    public void eliminarUsuario(Usuario u) {
        UsuarioBD.remove(u);
    }
}
