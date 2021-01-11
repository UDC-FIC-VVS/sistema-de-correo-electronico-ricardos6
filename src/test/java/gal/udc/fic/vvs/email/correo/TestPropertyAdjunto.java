package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyAdjunto {

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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoTexto);

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerTamaño() + archivo.obtenerTamaño(), correo.obtenerTamaño());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerVisualizacion(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + archivo.obtenerPreVisualizacion(),
				correo.obtenerVisualizacion());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerRuta(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerRuta());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRutaConPadre(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio, String nombreCarpeta) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		carpeta.añadir(correo);

		assertEquals(carpeta.obtenerPreVisualizacion() + " > " + mensaje.obtenerPreVisualizacion(),
				correo.obtenerRuta());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyEstablecerLeido(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		correo.establecerLeido(true);

		assertEquals(0, correo.obtenerNoLeidos());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerNoLeidos(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(1, correo.obtenerNoLeidos());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerPreVisualizacion());
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
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPadre(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio, String nombreCarpeta) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		carpeta.añadir(correo);

		assertEquals(carpeta, correo.obtenerPadre());
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * * Probamos que si queremos obtener un padre que no hay, nos devuelve null.
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPadreNoPadre(String nombreTexto, String contenidoTexto, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(null, correo.obtenerPadre());
	}
}
