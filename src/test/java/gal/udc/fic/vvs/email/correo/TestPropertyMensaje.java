package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyMensaje {

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
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyLeidoYObtener(String nombreTexto, String contenidoTexto) {

		Texto texto = new Texto(nombreTexto, nombreTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(1, mensaje.obtenerNoLeidos());

		mensaje.establecerLeido(true);

		assertEquals(0, mensaje.obtenerNoLeidos());
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
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombreTexto, String contenidoTexto) {

		Texto texto = new Texto(nombreTexto, nombreTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(1, mensaje.obtenerNoLeidos());

		mensaje.establecerLeido(true);

		assertEquals(0, mensaje.obtenerNoLeidos());
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
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreTexto, String contenidoTexto) {

		Texto texto = new Texto(nombreTexto, nombreTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());

		mensaje.establecerLeido(true);

		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
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
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombreTexto, String contenidoTexto) {

		Texto texto = new Texto(nombreTexto, nombreTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(mensaje.obtenerPreVisualizacion(), mensaje.obtenerPreVisualizacion());
	}
}
