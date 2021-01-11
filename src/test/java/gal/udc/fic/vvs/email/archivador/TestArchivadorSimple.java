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
public class TestArchivadorSimple {

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Corner case donde el espacio del archivadorSimple
	 * es negativo
	 */
	@Test
	public void testAlmacenarCorreoEspacioNegativo() {

		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = -10;
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);

		Texto texto = new Texto("Nombre Texto", "Contenido Texto");

		Correo correo = new Mensaje(texto);

		assertEquals(false, archivadorSimple.almacenarCorreo(correo));
	}
	
	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Corner case donde el espacio del archivadorSimple
	 * es negativo
	 */
	@Test
	public void testAlmacenarCorreoEspacioNoSuficiente() {

		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 1;
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);

		Texto texto = new Texto("Nombre Texto", "Contenido Texto");

		Correo correo = new Mensaje(texto);
		
		
		assertEquals(false, archivadorSimple.almacenarCorreo(correo));
		assertEquals(1, archivadorSimple.obtenerEspacioDisponible());
	}
}
