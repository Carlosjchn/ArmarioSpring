package com.dam.armario.entidades.ropa;

public class Camiseta extends Ropa{
	private boolean mangas;
	private boolean cuello; //redondo o de pico
	private boolean estampado; 

	//CONTRUCTORS
	public Camiseta () {}
	
	public Camiseta (String mangas, String cuello, String estampado) {
		if (mangas.equals("1")) {
			this.mangas = true;
		} else if (mangas.equals("2")) {
			this.mangas= false;
		}

		if (cuello.equals("1")) {
			this.mangas = true;
		} else if (cuello.equals("2")) {
			this.mangas= false;
		}

		if (estampado.equals("1")) {
			this.estampado = true;
		} else if (estampado.equals("2")) {
			this.estampado= false;
		}


	}
	
	
	//GETS AND SETS
	
		public boolean getMangaString(){
			return mangas;
        }
		public void setMangaString(boolean mangas){
            this.mangas = mangas;
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
		return  "Camiseta [" + super.toString() + ", manga=" + mangas + ", cuello=" + cuello +  ", estampado=" + estampado + "]";
	} 
	
    
}
