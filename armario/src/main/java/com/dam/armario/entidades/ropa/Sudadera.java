package com.dam.armario.entidades.ropa;

public class Sudadera extends Ropa{
	private Boolean capucha; 
	private Boolean estampado;
	
	//constructors
	public Sudadera( ) {}
	
	public Sudadera(String color, String talla, String marca,  String material, String estilo, boolean capucha, Boolean estampado) {
		super();
		this.capucha = capucha;
		this.estampado = estampado;
	}
	//GETS AND SETS
	
	public Boolean getCapucha (){
		return capucha;
    }

	public void setCapucha(Boolean capucha) {
        this.capucha = capucha;
    }

	public Boolean getEstampado (){
        return estampado;
    }

	public void setEstampado(Boolean estampado) {
        this.estampado = estampado;
    }

	@Override
	public String toString() {
		return "Sudadera [" + super.toString() + "capucha=" + capucha + ", estampado=" + estampado + "]";
	}
	
	
    
}
