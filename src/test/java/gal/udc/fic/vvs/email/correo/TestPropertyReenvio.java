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
public class TestPropertyReenvio {

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerRuta(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerRuta());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRutaConPadre(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera, String nombreCarpeta) throws OperacionInvalida {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		carpeta.añadir(correo);

		assertEquals(nombreCarpeta + " (1) > " + mensaje.obtenerPreVisualizacion(), correo.obtenerRuta());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPadre(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera, String nombreCarpeta) throws OperacionInvalida {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		carpeta.añadir(correo);

		assertEquals(carpeta, correo.obtenerPadre());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyEstablecerLeido(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(1, correo.obtenerNoLeidos());

		correo.establecerLeido(true);

		assertEquals(0, correo.obtenerNoLeidos());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerNoLeidos(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(1, correo.obtenerNoLeidos());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(mensaje.obtenerTamaño() + cabecera.obtenerTamaño(), correo.obtenerTamaño());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
	}

	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerPreVisualizacion());
	}
	
	/**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerVisualizacion(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(cabecera.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ mensaje.obtenerVisualizacion() + "\n---- Fin correo reenviado ----", correo.obtenerVisualizacion());
	}
}
