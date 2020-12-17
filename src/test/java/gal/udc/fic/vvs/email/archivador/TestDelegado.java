package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
public class TestDelegado {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * Corner case en el que el espacio del archivador es 0 y salta una excepcion al
	 * intentar almacenar un correo con el delegado.
	 */
	@Test(expected = NullPointerException.class)
	public void testAlmacenarCorreo() {

		ArchivadorSimple archivadorSimple = new ArchivadorSimple("nombreArchivadorSimple", 0);

		Delegado delegado = new Delegado(archivadorSimple);

		// creamos un correo de texto para insertar desde el delegado
		Texto texto = new Texto("nombreTexto", "contenidoTexto");

		Correo correo = new Mensaje(texto);

		assertEquals(false, delegado.almacenarCorreo(correo));
	}
}
