package com.dam.armario.entidades.ropa;

public class Jerseis extends Ropa{
	private boolean cuello; // redondo o de pico
	private boolean tipoDeTela; // fino o de tela gruesa
	
	//constructors
	public Jerseis( ) {}
	
	public Jerseis (String cuello, String tipoDeTela) {
		if (cuello.equals("1") ) {
			this.cuello = true;
		} else if (cuello.equals("2") ) {
			this.cuello= false;
		}
	
		if (tipoDeTela.equals("1")) {
			this.tipoDeTela = true;
		} else if (tipoDeTela.equals("2")) {
			this.tipoDeTela= false;
		}
	
	
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
