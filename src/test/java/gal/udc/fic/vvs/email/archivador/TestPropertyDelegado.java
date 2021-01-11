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
public class TestPropertyDelegado {

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
	 * @param nombreArchivadorSimple  Categoria: String cualquiera. Representantes:
	 *                                Generados automaticamente.
	 * @param espacioArchivadorSimple Categoria: Enteros positivos. Representantes:
	 *                                Generados automaticamente.
	 * @param nombreTexto             Categoria: String cualquiera. Representantes:
	 *                                Generados automaticamente.
	 * @param contenidoTexto          Categoria: String cualquiera. Representantes:
	 *                                Generados automaticamente.
	 */
	@Property
	public void testPropertyAlmacenarCorreo(String nombreArchivadorSimple, int espacioArchivadorSimple,
			String nombreTexto, String contenidoTexto) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		assumeThat(espacioArchivadorSimple, greaterThan(contenidoTexto.length()));

		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);

		Delegado delegado = new Delegado(archivadorSimple);

		// creamos un correo de texto para insertar desde el delegado
		Texto texto = new Texto(nombreTexto, contenidoTexto);

		Correo correo = new Mensaje(texto);

		assertEquals(true, delegado.almacenarCorreo(correo));
	}

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
	 * @param nombreArchivadorSimple  Categoria: String cualquiera. Representantes:
	 *                                Generados automaticamente.
	 * @param espacioArchivadorSimple Categoria: Enteros positivos. Representantes:
	 *                                Generados automaticamente.
	 */
	@Property
	public void testPropertyEstablecerYObtenerDelegado(String nombreArchivadorSimple, int espacioArchivadorSimple) {

		assumeThat(espacioArchivadorSimple, greaterThan(-1));
		
		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacioArchivadorSimple);

		Delegado delegado = new Delegado(archivador);

		delegado.establecerDelegado(archivador);

		assertEquals(archivador, delegado.obtenerDelegado());
	}
}
