package com.dam.armario.entidades.ropa;

public class Zapatos extends Ropa{
	
	
	
	//constructors
	public Zapatos() {
		super();
	}
	
	public Zapatos (String color, String talla, String marca,  String material, String estilo) {
		super(color, talla, marca, material, estilo);
	}
	
	@Override
	public String toString() {
		return "Zapatos [" + super.toString() + "]";
	}
	
	
}
