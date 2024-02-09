package com.dam.armario.entidades.ropa;

public class Complementos {

	private String tipo; //con capucha, sin capucha, cremallera...
	private String estilo;
	
	//constructors
	public Complementos( ) {
		
	}
	public Complementos(String tipo, String estilo) {
		super();
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
