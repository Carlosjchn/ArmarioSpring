package com.dam.armario.entidades.ropa;

public class Sudadera extends Ropa{
	private Boolean capucha; 
	private String estampado;
	
	//constructors
	public Sudadera( ) {}
	
	public Sudadera(String color, String talla, String marca,  String material, String estilo, boolean capucha, String estampado) {
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

	public String getEstampado (){
        return estampado;
    }

	public void setEstampado(String estampado) {
        this.estampado = estampado;
    }

	@Override
	public String toString() {
		return "Sudadera [" + super.toString() + "capucha=" + capucha + ", estampado=" + estampado + "]";
	}
	
	
    
}
