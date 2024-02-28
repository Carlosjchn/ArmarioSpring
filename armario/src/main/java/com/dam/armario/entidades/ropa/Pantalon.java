package com.dam.armario.entidades.ropa;

public class Pantalon extends Ropa{
    private boolean longitud;  // corto o largo


	
	public Pantalon() {}

	public Pantalon(String color, String talla, String marca,  String material, String estilo, boolean longitud) {
		super(color, talla, marca, material, estilo);
		this.longitud = longitud;
		this.estilo = estilo;
	}

	public boolean getLongitud() {
		return longitud;
    }
	public void setLongitud(boolean longitud) {
        this.longitud = longitud;
    }


	@Override
	public String toString() {
		return "Pantalon [" + super.toString() + "longitud=" + longitud + "]";
	}
	
}
