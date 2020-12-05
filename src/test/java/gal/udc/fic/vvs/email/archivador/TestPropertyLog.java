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
public class TestPropertyLog {

	/**
	 * Nivel da prueba: Unitaria
	 * Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas
	 * Mecanismo de selección de los datos:
	 * 		Categoria:
	 * 			Strings cualesquiera. Como representate elegimos dos String
	 * 			generados automaticamente.
	 * 			Numeros enteros positivos generados automaticamentea		
	 * 
	 */
	@Property
	public void testPropertyLogAlmacenarCorreo(String nombreArchivadorSimple, int espacioArchivadorSimple,
			String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
		Delegado delegado = new Delegado(archivador);

		Log log = new Log(delegado);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Correo correo = new Mensaje(texto);

		assertEquals(true, log.almacenarCorreo(correo));
	}
	
	/**
	 * Nivel da prueba: Unitaria
	 * Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas
	 * Mecanismo de selección de los datos:
	 * 		Categoria:
	 * 			Strings cualesquiera. Como representate elegimos dos String
	 * 			generados automaticamente.
	 * 			Numeros enteros positivos generados automaticamentea		
	 * 
	 */

	@Property
	public void testPropertyLogAlmacenarCorreoYObtenerEspacioDisponible(String nombreArchivadorSimple,
			int espacioArchivadorSimple, String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
		Delegado delegado = new Delegado(archivador);

		Log log = new Log(delegado);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Correo correo = new Mensaje(texto);

		log.almacenarCorreo(correo);

		assertEquals(espacioArchivadorSimple - texto.obtenerTamaño(), log.obtenerEspacioDisponible());
	}
	
	/**
	 * Nivel da prueba: Unitaria
	 * Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas
	 * Mecanismo de selección de los datos:
	 * 		Categoria:
	 * 			Strings cualesquiera. Como representate elegimos dos String
	 * 			generados automaticamente.
	 * 			Numeros enteros positivos generados automaticamentea		
	 * 
	 */
	
	@Property
	public void testPropertyLogObtenerNombre(String nombreArchivadorSimple,
			int espacioArchivadorSimple, String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
		Delegado delegado = new Delegado(archivador);

		Log log = new Log(delegado);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Correo correo = new Mensaje(texto);

		log.almacenarCorreo(correo);

		assertEquals(nombreArchivadorSimple, log.obtenerNombre());
	}
	
	/**
	 * Nivel da prueba: Unitaria
	 * Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas
	 * Mecanismo de selección de los datos:
	 * 		Categoria:
	 * 			Strings cualesquiera. Como representate elegimos dos String
	 * 			generados automaticamente.
	 * 			Numeros enteros positivos generados automaticamentea		
	 * 
	 */
	@Property
	public void testPropertyLogEstablecerDelegadoObtenerDelegado(String nombreArchivadorSimple,
			int espacioArchivadorSimple, String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);
		Delegado delegado = new Delegado(archivador);

		Log log = new Log(delegado);
		
		Texto texto = new Texto(nombreTexto, contenidoTexto);		
		Correo correo = new Mensaje(texto);
		
		log.almacenarCorreo(correo);	
		log.establecerDelegado(delegado);

		assertEquals(delegado, log.obtenerDelegado());
	}
}
