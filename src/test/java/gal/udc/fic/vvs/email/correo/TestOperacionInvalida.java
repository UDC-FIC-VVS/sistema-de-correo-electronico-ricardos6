package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOperacionInvalida {

	/**
	 * Probamos que podemos crear una excepcion OperacionInvalida dandole un String
	 * donde podemos especificar un mensaje y obtenerlo
	 */
	@Test
	public void test() {
		
		Exception e = new OperacionInvalida("Descripcion Operacion Invalida");
		
		assertEquals("Descripcion Operacion Invalida", e.getMessage());
	}
}
