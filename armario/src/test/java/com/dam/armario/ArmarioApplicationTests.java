package com.dam.armario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dam.armario.entidades.outfits.Outfits;
import com.dam.armario.entidades.ropa.*;
import com.dam.armario.entidades.usuario.Usuario;
import com.dam.armario.excepciones.ExcepcionPass;
import com.dam.armario.excepciones.NombreExcepcion;
import com.dam.armario.repositorio.UsuarioBD;
import com.dam.armario.servicios.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest
class ArmarioApplicationTests {

	UsuarioBD listaUsuarios = new UsuarioBD();
	ServicioUsuario funcionesUsuario = new ServicioUsuario();
	ServicioRopa funcionesRopa = new ServicioRopa();
	ServicioComun funcionesComun = new ServicioComun();
	ServicioOutfit funcionOutfit = new ServicioOutfit();

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
			assertEquals(listaUsuarios.buscarNombre("nombrenoValido"), new NombreExcepcion());
		} catch (NombreExcepcion e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAltaUsuario() {
		ArrayList<String> datosUsuario = new ArrayList<>();
		datosUsuario.add("nombreUsuario");
		datosUsuario.add("correo@correo.com");
		datosUsuario.add("contraseña123");
		datosUsuario.add("recuperar1");
		funcionesUsuario.alta(datosUsuario, listaUsuarios);

		assertTrue(listaUsuarios.getUsuarioBD().get(0).getNombre().equals("nombreUsuario"));
	}

	@Test
	public void testAltaUsuario2() {
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		listaUsuarios.altaUsuario(usuario);
		assertTrue(listaUsuarios.getUsuarioBD().contains(usuario));
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
	public void testCheckSesion() {
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

		assertTrue(funcionesUsuario.checkSesion(listaUsuarios));
	}

	@Test
	public void testCheckSesion2() {
		ArrayList<String> datosRegistro = new ArrayList<>();
		datosRegistro.add("nombreUsuario");
		datosRegistro.add("correo@correo.com");
		datosRegistro.add("contraseña123");
		datosRegistro.add("recuperar1");

		funcionesUsuario.alta(datosRegistro, listaUsuarios);

		assertFalse(funcionesUsuario.checkSesion(listaUsuarios));
	}

	@Test
	public void testCorreo() {
		String correo = "correo@correo.com";

		assertTrue(funcionesComun.validarCorreoElectronico(correo));
	}

	@Test
	public void testCorreo2() {
		String correo = "correoNoValido";

		assertFalse(funcionesComun.validarCorreoElectronico(correo));
	}

	@Test
	public void validarContraseña() {
		String contraseña = "Contraseña!123";

		assertTrue(funcionesComun.validarContrasena(contraseña));
	}

	@Test
	public void validarContraseña2() {
		String contraseña = "contraseña123";

		assertFalse(funcionesComun.validarContrasena(contraseña));
	}

	@Test
	public void testElegirColor() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");

		Ropa ropa = new Sudadera();

		funcionesRopa.elegirColor(ropa, datosRopa);

		assertEquals(ropa.getColor(), "Rojo");
	}

	@Test
	public void testElegirTalla() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");
		datosRopa.add("3");

		Ropa ropa = new Sudadera();

		funcionesRopa.elegirTalla(ropa, datosRopa);

		assertEquals(ropa.getTalla(), "M");
	}

	@Test
	public void testElegirMarca() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");
		datosRopa.add("3");
		datosRopa.add("Nike");

		Ropa ropa = new Sudadera();

		funcionesRopa.elegirMarca(ropa, datosRopa);

		assertEquals(ropa.getMarca(), "Nike");
	}

	@Test
	public void testElegirMaterial() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");
		datosRopa.add("3");
		datosRopa.add("Nike");
		datosRopa.add("1");

		Ropa ropa = new Sudadera();

		funcionesRopa.elegirMaterial(ropa, datosRopa);

		assertEquals(ropa.getMaterial(), "Algodón");
	}

	@Test
	public void testCrearObjeto() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");
		datosRopa.add("3");
		datosRopa.add("Nike");
		datosRopa.add("1");
		datosRopa.add("1");

		Ropa prueba = funcionesRopa.crearObjeto(datosRopa);

		assertEquals(funcionesRopa.crearObjeto(datosRopa), prueba);
	}

	@Test
	public void testGuardarPrenda() {

		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		assertTrue(listaUsuarios.getUsuarioBD().get(0).getRopaBD().contains(sudadera));
	}

	@Test
	public void testAltaPrenda() {
		ArrayList<String> datosRopa = new ArrayList<>();
		datosRopa.add("1");
		datosRopa.add("4");
		datosRopa.add("3");
		datosRopa.add("Nike");
		datosRopa.add("1");
		datosRopa.add("1");

		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);

		funcionesRopa.alta(datosRopa, listaUsuarios);

		assertTrue(listaUsuarios.getUsuarioBD().get(0).getRopaBD().get(0).getColor().equals("Rojo"));
	}

	@Test
	public void testGuardarOutfit() {
		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		Outfits outfit = new Outfits();
		outfit.addPrenda(sudadera);
		outfit.setNombreOutfit("Outfit1");

		funcionOutfit.guardarOutfit(outfit, listaUsuarios);

		assertEquals(1, listaUsuarios.getUsuarioBD().get(0).getOutfitsBD().size());
		assertEquals("Outfit1", listaUsuarios.getUsuarioBD().get(0).getOutfitsBD().get(0).getNombreOutfit());
	
	}

	@Test
	public void testAltaOutfit() {
		ArrayList<String> opcionOutfit = new ArrayList<>();
		opcionOutfit.add("1");
		opcionOutfit.add("Outfit1");

		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		funcionOutfit.alta(opcionOutfit, listaUsuarios);

		assertEquals(1, listaUsuarios.getUsuarioBD().get(0).getOutfitsBD().size());
		assertEquals("Outfit1", listaUsuarios.getUsuarioBD().get(0).getOutfitsBD().get(0).getNombreOutfit());
	}

	@Test
	public void testCifrarContraseña(){
		Usuario u = new Usuario();
		String contraseña = "Contraseña123";
		u.setPassword(contraseña);
		String contraseñaCifrada = u.cifrarPassword();

		assertNotEquals(contraseñaCifrada,contraseña);
	}

	@Test
	public void testAñadirSaldo(){
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.añadirSaldo("50");

		assertEquals(150, usuario.getSaldo());
	}

	@Test
	public void testCheckPass(){
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		try {
			assertTrue(usuario.checkPass("contraseña123"));
		} catch (ExcepcionPass e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCheckPass2(){
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		try {
			assertEquals(new ExcepcionPass(), usuario.checkPass("contraseñaIncorrecta"));
		} catch (ExcepcionPass e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVenderPrenda(){
		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		usuario.venderPrenda("1", 25.5);

		assertEquals(25.5, usuario.getRopaBD().get(0).getPrecio());
	}

	@Test
	public void testRetirarPrenda(){
		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);
		usuario.venderPrenda("1", 25.5);

		usuario.retirarPrenda("1");

		assertEquals(0, usuario.getRopaBD().get(0).getPrecio());
	}

	@Test
    public void testRemovePrenda(){
		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		usuario.removePrenda(sudadera);

		assertEquals(0, usuario.getOutfitsBD().size());
	}

	@Test
	public void testRemovePrendaindex(){
		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);

		usuario.removePrendaIndex(1);

		assertEquals(0, usuario.getOutfitsBD().size());
	}

	@Test
	public void testRemoveOutfit(){
		ArrayList<String> opcionOutfit = new ArrayList<>();
		opcionOutfit.add("1");
		opcionOutfit.add("Outfit1");

		Ropa sudadera = new Sudadera();
		Usuario usuario = new Usuario("nombreUsuario", "correo@correo.com", "contraseña123", "recuperar1");
		usuario.setLogueado(true);
		listaUsuarios.altaUsuario(usuario);
		funcionesRopa.guardarPrenda(sudadera, listaUsuarios);
		funcionOutfit.alta(opcionOutfit, listaUsuarios);

		usuario.removeOutfit(1);

		assertEquals(0, usuario.getOutfitsBD().size());
	}
}
