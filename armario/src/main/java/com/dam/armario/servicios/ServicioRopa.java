package com.dam.armario.servicios;
import com.dam.armario.entidades.ropa.*;
import com.dam.armario.repositorio.*;
import com.dam.armario.frontend.*;
import java.util.*;
public class ServicioRopa {
    MenuRopa menuRopa = new MenuRopa();
    public void añadirPrenda(String[] menuPrenda) {

         switch (menuPrenda[0]) {
            case "1":
                Ropa abrigo = new Abrigo();
            case "2":
                Ropa camisa = new Camisa();
            case "3":
                Ropa camiseta = new Camiseta();
            case "4":    
                Ropa jersey = new Jerseis();
            case "5": 
                Ropa pantalon = new Pantalon();   
            case "6":
                Ropa sudadera = new Sudadera();
            case "7":
                Ropa zapato = new Zapatos();   
            break;

            default:
                break;
         }
         
         
    }

    public void elegirColor(Ropa a, ArrayList<String> opcion ){
        String color = "";
        switch(opcion.get(0)){
            case "1":
                color = "Negro";
            case "2":
                color = "Blanco";
            case "3":
                color = "Azul";
            case "4":
                color = "Rojo";
            case "5":
                color = "Verde";
            case "6":
                color = "Multicolor";
        }
        a.setColor(color);
    }

    public void elegirTalla(Ropa a, ArrayList<String> opcion ){
        String talla = "";
        switch(opcion.get(1)){
            case "1":
                talla = "XS";
            case "2":
                talla = "S";
            case "3":
                talla = "M";
            case "4":
                talla = "L";
            case "5":
                talla = "XL";
        }
        a.setColor(talla);
    }

    public void elegirMaterial(Ropa a, ArrayList<String> opcion ){
        String material = "";
        switch(opcion.get(2)){
            case "1":
                material = "Algodón";
            case "2":
                material = "Pana";
            case "3":
                material = "Nilon";
            case "4":
                material = "Poliester";
            case "5":
                material = "Cuero";
        }
        a.setColor(material);
    }
    public void verPrendas() {
        // Add logic to list all Ropa objects
    }

    public void sugerencias(String tipoUsuario) {
        // Add logic to provide style suggestions based on user type
    }
}
