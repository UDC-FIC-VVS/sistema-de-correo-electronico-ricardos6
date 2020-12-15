package gal.udc.fic.vvs.email.correo;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpeta {

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		String nombreCarpeta = "nombreCarpeta";
		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(true, carpeta.buscar(contenidoTexto).contains(mensaje));
	}
}
