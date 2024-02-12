package com.dam.armario.entidades.ropa;

public class Camiseta extends Ropa{
	private String tipo;//manga larga, corta, cuello corto
	private String estilo;

	//CONTRUCTORS
	public Camiseta () {
		
	}
	
	public Camiseta(String tipo, String estilo) {
		super();
		this.tipo = tipo;
		this.estilo = estilo;
	}
	
	
	//GETS AND SETS
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	} 
	
    
}
