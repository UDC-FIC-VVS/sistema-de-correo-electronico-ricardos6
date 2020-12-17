package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyOperacionInvalida {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param descripcion Categoria: String cualquiera. Representantes: Generados
	 *                    automaticamente.
	 */
	@Test
	public void testPropertyOperacionInvalida(String descripcion) {

		Exception e = new OperacionInvalida(descripcion);

		assertEquals(descripcion, e.getMessage());
	}
}
