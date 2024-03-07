package com.dam.armario.entidades.ropa;

public abstract class Ropa {
	protected String color;
	protected String talla;
	protected String marca;
	protected String material;
	protected double precio;
	protected String estilo;  // formal o sport


	//CONSTRUCTORS
	public Ropa() {
		
	}
	public Ropa(String color, String talla, String marca,  String material, String estilo) {
		this.color = color;
		this.talla = talla;
		this.marca = marca;
		this.material = material;
		this.estilo = estilo;
	}
	// GETS AND SETS 
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	


	//TO STRING
	@Override
	public String toString() {
		return "color=" + color + ", talla=" + talla + ", marca=" + marca + ", material=" + material ;
	}
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }	

	@Override
	public boolean equals(Object object) {
		if (this.color == ((Ropa)object).getColor()) {
			return true;
		}
		return false;
	}
	
	
	
	
    
}
