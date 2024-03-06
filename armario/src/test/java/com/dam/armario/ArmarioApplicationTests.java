package com.dam.armario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.dam.armario.controladores.ControladorMain;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.excepciones.NombreExcepcion;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.ServicioRopa;
import com.dam.armario.servicios.ServicioUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;




@SpringBootTest
class ArmarioApplicationTests {

	ControladorMain a = new ControladorMain();
	UsuarioBD a1 = new UsuarioBD();
	ServicioUsuario a2 = new ServicioUsuario();
	ServicioRopa a3 = new ServicioRopa();

	@Test
	public void testRegistro() {
		Usuario u1 = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		a1.altaUsuario(u1);
		try {
			assertEquals(a1.buscarNombre("nombreUsuario"), u1);
		} catch (NombreExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistro2() {
		Usuario u1 = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		a1.altaUsuario(u1);
		try {
			assertEquals(a1.buscarNombre(null), new NombreExcepcion());
		} catch (NombreExcepcion e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void testLogInUsuario() {
      
        String[] datosUsuario = new String[2];
        datosUsuario[0] = "nombreUsuario";
        datosUsuario[1] = "contraseña123";

        // Ejecución
        boolean loginCorrecto = a.logInUsuario(datosUsuario);

        // Verificación
        assertTrue(loginCorrecto);
    }
	
	
}



