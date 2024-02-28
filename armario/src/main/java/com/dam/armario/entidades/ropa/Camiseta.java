package com.dam.armario.entidades.ropa;

public class Camiseta extends Ropa{
	private boolean manga;
	private boolean cuello; //redondo o de pico
	private boolean estampado; 

	//CONTRUCTORS
	public Camiseta () {}
	
	public Camiseta(String color, String talla, String marca, String material, String estilo, boolean manga, boolean cuello, boolean estampado){
		super(color, talla, marca, material, estilo);
		this.manga = manga;
		this.cuello = cuello;
		this.estampado = estampado;
	}
	
	
	//GETS AND SETS
	
		public boolean getMangaString(){
			return manga;
        }
		public void setMangaString(boolean manga){
            this.manga = manga;
        }
		
        public boolean getCuelloString(){
            return cuello;
        }
		public void setCuelloString(boolean cuello){
            this.cuello = cuello;
        }
		
        public boolean getEstampadoString(){
            return estampado;
        }
		public void setEstampadoString(boolean estampado){
            this.estampado = estampado;
        }


	@Override
	public String toString() {
		return  "Camiseta [" + super.toString() + ", manga=" + manga + ", cuello=" + cuello +  ", estampado=" + estampado + "]";
	} 
	
    
}
