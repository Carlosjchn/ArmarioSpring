package com.dam.armario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.excepciones.NombreExcepcion;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.ServicioComun;
import com.dam.armario.servicios.ServicioRopa;
import com.dam.armario.servicios.ServicioUsuario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest
class ArmarioApplicationTests {

	UsuarioBD listaUsuarios = new UsuarioBD();
	ServicioUsuario funcionesUsuario = new ServicioUsuario();
	ServicioRopa funcionesRopa = new ServicioRopa();
	ServicioComun funcionesComun = new ServicioComun();


	@Test
	public void testBuscarNombre() {
		Usuario u1 = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		listaUsuarios.altaUsuario(u1);
		try {
			assertEquals(listaUsuarios.buscarNombre("nombreUsuario"), u1);
		} catch (NombreExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscarNombre2() {
		Usuario u1 = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		listaUsuarios.altaUsuario(u1);
		try {
			assertEquals(listaUsuarios.buscarNombre(null), new NombreExcepcion());
		} catch (NombreExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAltaUsuario() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuarios.add(usuario);

		ArrayList<String> datosUsuario = new ArrayList<>();
		datosUsuario.add("nombreUsuario");
		datosUsuario.add("correo@correo.com");
		datosUsuario.add("contraseña123");
		datosUsuario.add("recuperar1");
		funcionesUsuario.alta(datosUsuario, listaUsuarios);



		 assertTrue(listaUsuarios.getUsuarioBD().equals(usuarios));
	}

	@Test
	public void testLogInUsuario() {

		ArrayList<String> datosRegistro = new ArrayList<>();
		datosRegistro.add("nombreUsuario");
		datosRegistro.add("correo@correo.com");
		datosRegistro.add("contraseña123");
		datosRegistro.add("recuperar1");
		funcionesUsuario.alta(datosRegistro, listaUsuarios);

		String[] datosUsuario = new String[2];
		datosUsuario[0] = "nombreUsuario";
		datosUsuario[1] = "contraseña123";

		// Ejecución
		assertTrue(funcionesUsuario.logInUsuario(listaUsuarios, datosUsuario));


	}

	@Test
	public void testRecuperarUsuarios() throws Exception {
		ArrayList<String> datosRegistro = new ArrayList<>();
		datosRegistro.add("nombreUsuario");
		datosRegistro.add("correo@correo.com");
		datosRegistro.add("contraseña123");
		datosRegistro.add("recuperar1");
		funcionesUsuario.alta(datosRegistro, listaUsuarios);

		Usuario userRecuperar = funcionesUsuario.recuperarUsuario(listaUsuarios, "recuperar1");
	
		assertEquals(listaUsuarios.getUsuarioBD().get(0), userRecuperar);
	}

	@Test
	public void testCheckSesion(){
		ArrayList<String> datosRegistro = new ArrayList<>();
		datosRegistro.add("nombreUsuario");
		datosRegistro.add("correo@correo.com");
		datosRegistro.add("contraseña123");
		datosRegistro.add("recuperar1");

		funcionesUsuario.alta(datosRegistro, listaUsuarios);

		String[] datosLogin = new String[2];
		datosLogin[0] = "nombreUsuario";
		datosLogin[1] = "contraseña123";

		funcionesUsuario.logInUsuario(listaUsuarios, datosLogin);

		assertTrue (funcionesUsuario.checkSesion(listaUsuarios));
	}

	@Test
	public void testCheckSesion2(){
		ArrayList<String> datosRegistro = new ArrayList<>();
		datosRegistro.add("nombreUsuario");
		datosRegistro.add("correo@correo.com");
		datosRegistro.add("contraseña123");
		datosRegistro.add("recuperar1");

		funcionesUsuario.alta(datosRegistro, listaUsuarios);

		assertFalse (funcionesUsuario.checkSesion(listaUsuarios));
	}

	@Test
	public void testCorreo(){
		String correo = "correo@correo.com";

		assertTrue(funcionesComun.validarCorreoElectronico(correo));
	}

	@Test
	public void testCorreo2(){
		String correo = "correoNoValido";

		assertFalse(funcionesComun.validarCorreoElectronico(correo));
	}

	@Test
	public void validarContraseña(){
		String contraseña = "Contraseña!123";

		assertTrue(funcionesComun.validarContrasena(contraseña));
	}

	@Test
	public void validarContraseña2(){
		String contraseña = "contraseña123";

		assertFalse(funcionesComun.validarContrasena(contraseña));
	}
}
