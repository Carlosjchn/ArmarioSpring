package com.dam.armario.servicios;



public class ServicioComun {


    public boolean validarCorreoElectronico(String correo) {
        return correo.matches(Constantes.patronCorreo);
    }

    public boolean validarContrasena(String contrasena) {
        return contrasena.matches(Constantes.patronContraseña);
    }

}
