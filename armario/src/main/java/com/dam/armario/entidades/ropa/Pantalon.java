package com.dam.armario.entidades.ropa;

public class Pantalon {
    private String tipo;//vaquero, PANA, CHINO...
	private String estilo;

	
	
	public Pantalon() {
		super();
	}

	public Pantalon(String tipo, String estilo) {
		super();
		this.tipo = tipo;
		this.estilo = estilo;
	}

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