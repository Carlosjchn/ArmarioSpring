package com.dam.armario.entidades.ropa;

public class Jerseis extends Ropa{
	private String cuello; // redondo o de pico
	private String tipoDeTela; // fino o de tela gruesa
	
	//constructors
	public Jerseis( ) {}
	
	public Jerseis (String color, String talla, String marca,  String material, String estilo, String cuello, String tipoDeTela) {
		super();
		this.cuello = cuello;
		this.tipoDeTela= tipoDeTela;
	}

	//GETS AND SETS
	public String getTipo() {
		return tipoDeTela; 
	}
	public void setTipo(String tipo) {
		this.tipoDeTela = tipo;
	}
	
	public String getCuello() {
        return cuello;
    }
	public void setCuello(String cuello) {
        this.cuello = cuello;
    }

	@Override
	public String toString() {
		return "Jerseis [" + super.toString() + "tipo de tela=" + tipoDeTela + ", cuello=" + cuello + "]";
	}
	
	
}
