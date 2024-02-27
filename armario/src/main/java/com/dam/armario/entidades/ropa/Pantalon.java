package com.dam.armario.entidades.ropa;

public class Pantalon extends Ropa{
    private String longitud;  // corto o largo


	
	public Pantalon() {
		super();
	}

	public Pantalon(String color, String talla, String marca,  String material, String estilo, String longitud) {
		super(color, talla, marca, material, estilo);
		this.longitud = longitud;
		this.estilo = estilo;
	}

	public String getLongitud() {
		return longitud;
    }
	public void setLongitud(String longitud) {
        this.longitud = longitud;
    }


	@Override
	public String toString() {
		return "Pantalon [" + super.toString() + "longitud=" + longitud + "]";
	}
	
}
