package com.dam.armario.entidades.ropa;

public class Abrigo extends Ropa{
	private String tipo; //con capucha, sin capucha, cremallera...
	private String estilo;
	
	//constructors
	public Abrigo( ) {
		
	}
	public Abrigo(String color, String talla, String marca,  String material, String tipo, String estilo) {
		super(color, talla, marca, material, estilo);
		this.tipo = tipo;
		this.estilo = estilo;
	}
	//GETS AND SETS
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	
}
