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
public class TestLog {

	/**
	 * Nivel da prueba: Unitaria
	 * Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, negativas
	 * Mecanismo de selección de los datos:
	 * 		Categoria:
	 * 			Strings cualesquiera. Como representate elegimos dos String
	 * 			generados automaticamente.
	 * 			-1 para el valor del espacio del ArchivadorSimple
	 * 
	 * Se espera que falle el almacenamiento del correo por el Log	
	 * 
	 */
	@Test(expected = NullPointerException.class)
	public void testLogAlmacenarCorreo() {

		String nombreArchivadorSimple = "Nombre Archivador Simple";
		int espacioArchivadorSimple = -1;
		String nombreTexto = "Nombre Texto";
		String contenidoTexto = "Contenido Texto";

		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
		Delegado delegado = new Delegado(archivador);

		Log log = new Log(delegado);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Correo correo = new Mensaje(texto);

		assertEquals(false, log.almacenarCorreo(correo));
	}
}
