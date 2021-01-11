package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOperacionInvalida {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 */
	@Test
	public void test() {

		Exception e = new OperacionInvalida("Descripcion Operacion Invalida");

		assertEquals("Descripcion Operacion Invalida", e.getMessage());
	}
}
