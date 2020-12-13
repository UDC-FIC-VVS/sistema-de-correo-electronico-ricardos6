package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestMensaje {

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * * Este test falla, no encuentra el String "+-"
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       "+-".
	 */
	@Test
	public void testBuscarStringNoValido() {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "+-";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(1, mensaje.buscar("+-").size());
		assertEquals(false, mensaje.buscar("+-").contains(mensaje));
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positiva</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Metodo buscar funciona correctamente al no encontrar un string que no esta
	 * contenido en el mensaje.
	 * 
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombretexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       "contenidoTexto".
	 */
	@Test
	public void testBuscarNoEncuentra() {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(true, mensaje.buscar("no encuentra").isEmpty());
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positiva</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * No podemos usar propiedas por la existencia de algunas cadenas de caracteres
	 * con las que el metodo no funciona bien.
	 * 
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombretexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       "contenidoTexto".
	 */
	@Test
	public void testBuscar() {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(true, mensaje.buscar("texto").contains(mensaje));
	}
}
