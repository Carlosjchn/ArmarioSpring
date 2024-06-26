package com.dam.armario.entidades.usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dam.armario.entidades.ropa.*;
import com.dam.armario.excepciones.ExcepcionPass;
import com.dam.armario.servicios.Constantes;
import com.dam.armario.entidades.outfits.*;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String recuperar;
    private double saldo;
    private boolean Logueado = false;

    private ArrayList<Ropa> ropaBD = new ArrayList<Ropa>();
    private ArrayList<Outfits> outfitsBD = new ArrayList<Outfits>();


    public Usuario(String nombre, String email, String password, String recuperar) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.recuperar = recuperar;
        this.saldo = 100;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecuperar() {
        return recuperar;
    }

    public void setRecuperar(String recuperar) {
        this.recuperar = recuperar;
    }

    public boolean isLogueado() {
        return Logueado;
    }

    public void setLogueado(boolean logueado) {
        this.Logueado = logueado;
    }

    public ArrayList<Ropa> getRopaBD() {
        return ropaBD;
    }

    public Ropa getPrenda(int index) {
        try{
        return ropaBD.get(index);
        }catch(Exception e){
            return null;
        }
    }

    public int getIndex(Ropa prenda) {
        return getRopaBD().indexOf(prenda);
    }

    public void altaRopa(Ropa ropa) {
        ropaBD.add(ropa);
    }

    public ArrayList<Outfits> getOutfitsBD() {
        return outfitsBD;
    }

    public void altaOutfit(Outfits outfit) {
        outfitsBD.add(outfit);
    }

    public Outfits elegirOutfit(int index) {
        return outfitsBD.get(index - 1);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void añadirSaldo(String saldo){
        this.saldo += Double.parseDouble(saldo);
    }

    public void setRopaBD(ArrayList<Ropa> ropaBD) {
        this.ropaBD = ropaBD;
    }

    public void setOutfitsBD(ArrayList<Outfits> outfitsBD) {
        this.outfitsBD = outfitsBD;
    }

    public String cifrarPassword() {
        String passwordCifrada = "";
        for (int i = 0; i < password.length(); i++) {
            if (i == 0 || i == password.length() - 1) {
                passwordCifrada += password.charAt(i);
            } else {
                passwordCifrada += "*";
            }
        }
        return passwordCifrada;
    }

    public void removeOutfit(int index){
        try{
        outfitsBD.remove(index-1);
        }catch(Exception e){
        }
    }

    public void venderPrenda(String numPrenda, Double precio){
        ropaBD.get(Integer.parseInt(numPrenda)-1).setPrecio(precio);
    }

    public void retirarPrenda(String numPrenda){
        ropaBD.get(Integer.parseInt(numPrenda)-1).setPrecio(0);
    }

    public void removePrenda(Ropa prenda){
        try{
        ropaBD.remove(prenda);
        }catch(Exception e){
        }
    }

    public void removePrendaIndex(int index){
        try{
        ropaBD.remove(index-1);
        }catch(Exception e){
        }
    }
    public boolean checkPass(String contraseña) throws ExcepcionPass{
        if(contraseña.equalsIgnoreCase(this.password)){
            return true;
        }else{
            throw new ExcepcionPass();
        }

    }
    
    public int getOutfitID(int index){
        return outfitsBD.get(index-1).getId();
    }

    public int getRopaID(int index){
        return ropaBD.get(index-1).getID();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
     
    public void modificarPerfilBBDD(Usuario u, String opcion, String cambio) {
    Connection conexion = null;
    PreparedStatement ps = null;

    try {
        // PASO 1: CONECTARSE
        Class.forName("org.mariadb.jdbc.Driver");
        conexion = DriverManager.getConnection(Constantes.BBDDurl, Constantes.BBDDUser, Constantes.BBDDPass);

        String columna = "";
        switch (opcion) {
            case "1": // Cambiar nombre de usuario
                columna = "nombre";
                setNombre(cambio);
                break;
            case "2": // Cambiar email
                columna = "email";
                setEmail(cambio);
                break;
            case "3": // Cambiar contraseña
                columna = "contrasena";
                setPassword(cambio);
                break;
            case "4": // Añadir saldo
                columna = "saldo";
                añadirSaldo(cambio);
                break;
            default:
                System.err.println("Opción no válida.");
                return;
        }

        String sql = "UPDATE usuarios SET " + columna + " = ? WHERE id = ?";
        ps = conexion.prepareStatement(sql);

        if (columna.equals("saldo")) {
            ps.setDouble(1, Double.parseDouble(cambio));
        } else {
            ps.setString(1, cambio);
        }
        ps.setInt(2, u.getId());

        ps.executeUpdate();


    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // PASO 4: DESCONECTARSE
        try {
            if (ps != null) ps.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}