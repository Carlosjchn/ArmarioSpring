package com.dam.armario.entidades.ropa;

public class Abrigo extends Ropa{
	private boolean capucha;

	
	//constructors
	public Abrigo( ) {}
		
	public Abrigo (String capucha) {
		if (capucha.equals("1")) {
			this.capucha = true;
		} else if (capucha.equals("2")) {
			this.capucha= false;
		}
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
