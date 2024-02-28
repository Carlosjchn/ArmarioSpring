package com.dam.armario.entidades.ropa;

public class Pantalon extends Ropa{
    private boolean longitud;  // corto o largo


	
	public Pantalon() {}

	public Pantalon(String longitud) {
		if (longitud.equals("1")) {
			this.longitud = true;
		} else if (longitud.equals("2")) {
			this.longitud = false;
		}
	}

	public boolean getLongitud() {
		return longitud;
    }
	public void setLongitud(boolean longitud) {
        this.longitud = longitud;
    }


	@Override
	public String toString() {
		return "Pantalon [" + super.toString() + ", longitud=" + longitud + "]";
	}
	
}
