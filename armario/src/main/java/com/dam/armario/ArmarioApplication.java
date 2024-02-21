package com.dam.armario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dam.armario.controladores.*;

@SpringBootApplication
public class ArmarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmarioApplication.class, args);
		ControladorMain main = new ControladorMain();
		main.inicio();
	}

}
