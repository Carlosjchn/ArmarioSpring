package com.dam.armario.entidades.ropa;

public class Camiseta extends Ropa{
	private String manga;
	private String cuello; //redondo o de pico
	private String estampado; 

	//CONTRUCTORS
	public Camiseta () {}
	
	public Camiseta(String color, String talla, String marca, String material, String estilo, String manga, String cuello, String estampado){
		super(color, talla, marca, material, estilo);
		this.manga = manga;
		this.cuello = cuello;
		this.estampado = estampado;
	}
	
	
	//GETS AND SETS
	
		public String getMangaString(){
			return manga;
        }
		public void setMangaString(String manga){
            this.manga = manga;
        }
		
        public String getCuelloString(){
            return cuello;
        }
		public void setCuelloString(String cuello){
            this.cuello = cuello;
        }
		
        public String getEstampadoString(){
            return estampado;
        }
		public void setEstampadoString(String estampado){
            this.estampado = estampado;
        }


	@Override
	public String toString() {
		return  "Camiseta [" + super.toString() + ", manga=" + manga + ", cuello=" + cuello +  ", estampado=" + estampado + "]";
	} 
	
    
}
