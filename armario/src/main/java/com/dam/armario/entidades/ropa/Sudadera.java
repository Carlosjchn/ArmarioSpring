package com.dam.armario.entidades.ropa;

public class Sudadera extends Ropa{
	private Boolean capucha; 
	private Boolean estampado;
	
	//constructors
	public Sudadera( ) {}
	
	public Sudadera(String capucha, String estampado) {
		if (capucha.equals("1") ) {
			this.capucha = true;
		}else if (capucha.equals("2") ) {
			this.capucha = false;
		}

		if (estampado.equals("1")) {
			this.estampado = true;
		}else if (estampado.equals("2")) {
			this.estampado = false;
		}
		super.precio=0;
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
		return "Sudadera [" + super.toString() + ", capucha=" + capucha + ", estampado=" + estampado + "]";
	}
	
	
    
}
