package com.dam.armario.entidades.ropa;

public class Jerseis extends Ropa{
	private boolean cuello; // redondo o de pico
	private boolean tipoDeTela; // fino o de tela gruesa
	
	//constructors
	public Jerseis( ) {}
	
	public Jerseis (String color, String talla, String marca,  String material, String estilo, boolean cuello, boolean tipoDeTela) {
		super();
		this.cuello = cuello;
		this.tipoDeTela= tipoDeTela;
	}

	//GETS AND SETS
	public boolean getTipo() {
		return tipoDeTela; 
	}
	public void setTipo(boolean tipo) {
		this.tipoDeTela = tipo;
	}
	
	public boolean getCuello() {
        return cuello;
    }
	public void setCuello(boolean cuello) {
        this.cuello = cuello;
    }

	@Override
	public String toString() {
		return "Jerseis [" + super.toString() + ", tipo de tela=" + tipoDeTela + ", cuello=" + cuello + "]";
	}
	
	
}
