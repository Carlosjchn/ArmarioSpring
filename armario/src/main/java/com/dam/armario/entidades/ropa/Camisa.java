package com.dam.armario.entidades.ropa;

public class Camisa extends Ropa{
	private Boolean mangas;
	private Boolean estampado;
	
	//constructors
	public Camisa() {}
	
	public Camisa(String color, String talla, String marca,  String material, String estilo, Boolean mangas, Boolean estampado) {
		super(color, talla, marca, material, estilo);
		this.mangas = mangas;
		this.estampado = estampado;
	}

	//GETS AND SETS
	
	public void setMangas(Boolean mangas) {		
		this.mangas = mangas;
    }

	public Boolean getMangas() {
        return mangas;
    }

	public void setEstampado(Boolean estampado) {		
		this.estampado = estampado;
    }

	public Boolean getEstampado() {
		return estampado;
	}



	@Override
	public String toString() {
		return "Camisa [" + super.toString() + "mangas=" + mangas + ", estampado=" + estampado + "]";
	}
	
	
}
