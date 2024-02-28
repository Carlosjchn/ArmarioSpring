package com.dam.armario.entidades.ropa;

public class Abrigo extends Ropa{
	private boolean capucha;

	
	//constructors
	public Abrigo( ) {}
	
	public Abrigo(String color, String talla, String marca,  String material, String estilo, Boolean capucha) {
		super(color, talla, marca, material, estilo);
		this.capucha = capucha;
	}
	
	//GETS AND SETS
	
	public boolean getCapucha (){
		return capucha;
	}

	public void setCapucha(boolean capucha) {
        this.capucha = capucha;
    }


	@Override
	public String toString() {
		return "Abrigo ["+ super.toString() + ", capucha=" + capucha + "]";
	}
	
	
}
