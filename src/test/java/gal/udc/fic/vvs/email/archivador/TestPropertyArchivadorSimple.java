package gal.udc.fic.vvs.email.archivador;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyArchivadorSimple {

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos
	 * 
	 */
	@Property
	public void testPropertyObtenerNombre(String nombre, int espacio) {

		assumeThat(espacio, greaterThan(-1));

		Archivador archivadorSimple = new ArchivadorSimple(nombre, espacio);

		assertEquals(nombre, archivadorSimple.obtenerNombre());
	}

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos
	 * 
	 */
	@Property
	public void testPropertyAlmacenarCorreo(String nombreArchivadorSimple, int espacioArchivadorSimple,
			String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);

		Texto texto = new Texto(nombreTexto, contenidoTexto);

		Correo correo = new Mensaje(texto);

		assertEquals(true, archivadorSimple.almacenarCorreo(correo));
	}

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos
	 * 
	 * ESTE TEST ES SKIPPED
	 */
//	@Property
//	public void testPropertyAlmacenarCorreoDemasiadoGrande(String nombreArchivadorSimple, int espacioArchivadorSimple,
//			String nombreTexto, String contenidoTexto) {
//
//		assumeThat(espacioArchivadorSimple, greaterThan(-1));
//		assumeThat(contenidoTexto.length(), greaterThan(espacioArchivadorSimple));
//
//		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
//
//		Texto texto = new Texto(nombreTexto, contenidoTexto);
//
//		Correo correo = new Mensaje(texto);
//
//		assertEquals(false, archivadorSimple.almacenarCorreo(correo));
//	}

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos generados
	 * automaticamente
	 * 
	 */
	@Property
	public void testPropertyObtenerEspacioDisponible(String nombre, int espacio) {

		Archivador archivadorSimple = new ArchivadorSimple(nombre, espacio);

		assertEquals(espacio, archivadorSimple.obtenerEspacioDisponible());
	}

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos generados
	 * automaticamente
	 */
	@Property
	public void testPropertyObtenerEspacioTotal(String nombre, int espacio) {

		assumeThat(espacio, greaterThan(-1));

		Archivador archivadorSimple = new ArchivadorSimple(nombre, espacio);

		assertEquals(espacio, archivadorSimple.obtenerEspacioTotal());
	}

	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente. Numeros enteros positivos generados
	 * automaticamente
	 * 
	 */
	@Property
	public void testPropertyObtenerDelegado(String nombre, int espacio) {

		assumeThat(espacio, greaterThan(-1));

		Archivador archivador = new ArchivadorSimple(nombre, espacio);

		archivador.establecerDelegado(archivador);

		assertEquals(null, archivador.obtenerDelegado());
	}
}
