package com.dam.armario.entidades.ropa;

public class Camisa extends Ropa{
	private Boolean mangas;
	private Boolean estampado;
	
	//constructors
	public Camisa() {}


	public Camisa (String mangas, String estampado) {
		if (mangas.equals("1")) {
			this.mangas = true;
		} else if (mangas.equals("2")) {
			this.mangas= false;
		}
	
		if (estampado.equals("1")) {
			this.estampado = true;
		}else if (estampado.equals("2")) {
			this.estampado = false;
		}
	
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
		return "Camisa [" + super.toString() + ", mangas=" + mangas + ", estampado=" + estampado + "]";
	}
	
	
}
