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
public class TestPropertyCarpeta {

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
	@Property
	public void testPropertyAñadir(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(mensaje.obtenerTamaño(), carpeta.obtenerTamaño());
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
	 * @param nombreCarpeta      Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * @param nombreTexto        Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * @param contenidoTexto     Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * @param nombreCarpetaPadre Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyAñadirCarpetaHijo(String nombreCarpeta, String nombreTexto, String contenidoTexto,
			String nombreCarpetaPadre) throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpetaPadre);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);
		carpetaPadre.añadir(carpeta);

		assertEquals(mensaje.obtenerTamaño(), carpetaPadre.obtenerTamaño());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyEstablecerLeido(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);
		carpeta.establecerLeido(true);

		assertEquals(0, carpeta.obtenerNoLeidos());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerNoLeido(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(1, carpeta.obtenerNoLeidos());
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
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: Generados
	 *                      automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreCarpeta) throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);

		assertEquals(Correo.ICONO_CARPETA, carpeta.obtenerIcono());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(nombreCarpeta + " (1)", carpeta.obtenerPreVisualizacion());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerVisualizacion(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(nombreCarpeta + " (1)", carpeta.obtenerVisualizacion());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyExplorar(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(true, carpeta.explorar().contains(mensaje));
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyEliminar(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);
		carpeta.eliminar(mensaje);

		assertEquals(false, carpeta.explorar().contains(mensaje));
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerHijo(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(mensaje, carpeta.obtenerHijo(0));
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRuta(String nombreCarpeta, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);

		assertEquals(nombreCarpeta + " (1)", carpeta.obtenerRuta());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRutaConCarpetaPadre(String nombreCarpeta, String nombreTexto, String contenidoTexto,
			String nombreCarpetaPadre) throws OperacionInvalida {

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpetaPadre);
		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);

		carpeta.añadir(mensaje);
		carpetaPadre.añadir(carpeta);

		assertEquals(nombreCarpetaPadre + " (1) > " + nombreCarpeta + " (1)", carpeta.obtenerRuta());
	}
}
