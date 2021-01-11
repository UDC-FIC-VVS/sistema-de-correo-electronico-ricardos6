package gal.udc.fic.vvs.email.correo;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyCarpetaLimitada {

	/**
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
	 * @param tamaño        Categoria: int cualquiera. Representantes: Generados
	 *                      automaticamente > 0.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRuta(String nombreCarpeta, int tamaño) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta, carpetaLimitada.obtenerRuta());
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
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: Generados
	 *                      automaticamente.
	 * @param tamaño        Categoria: int cualquiera. Representantes: Generados
	 *                      automaticamente > 0.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerRutaConPadre(String nombreCarpeta, String nombreCarpetaPadre, int tamaño)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		Carpeta carpetaPadre = new Carpeta(nombreCarpetaPadre);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 10);

		carpetaPadre.añadir(carpeta);

		assertEquals(nombreCarpetaPadre + " > " + nombreCarpeta, carpetaLimitada.obtenerRuta());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyEstablecerLeido(String nombreCarpeta, int tamaño, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 10);

		carpetaLimitada.añadir(new Mensaje(new Texto(nombreTexto, contenidoTexto)));

		carpetaLimitada.establecerLeido(true);

		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerNoLeido(String nombreCarpeta, int tamaño, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 10);

		carpetaLimitada.añadir(new Mensaje(new Texto(nombreTexto, contenidoTexto)));

		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombreCarpeta, int tamaño, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
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
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: Generados
	 *                      automaticamente.
	 * @param tamaño        Categoria: int cualquiera. Representantes: Generados
	 *                      automaticamente > 0.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreCarpeta, int tamaño) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
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
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: Generados
	 *                      automaticamente.
	 * @param tamaño        Categoria: int cualquiera. Representantes: Generados
	 *                      automaticamente > 0.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombreCarpeta, int tamaño) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta, carpetaLimitada.obtenerPreVisualizacion());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPreVisualizacionConHijo(String nombreCarpeta, int tamaño, String nombreTexto,
			String contenidoTexto) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(nombreCarpeta + " (1)", carpetaLimitada.obtenerPreVisualizacion());
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
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: Generados
	 *                      automaticamente.
	 * @param tamaño        Categoria: int cualquiera. Representantes: Generados
	 *                      automaticamente > 0.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerVisualizacion(String nombreCarpeta, int tamaño) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		assertEquals(nombreCarpeta, carpetaLimitada.obtenerVisualizacion());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerVisualizacionConHijo(String nombreCarpeta, int tamaño, String nombreTexto,
			String contenidoTexto) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(nombreCarpeta + " (1)", carpetaLimitada.obtenerVisualizacion());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyExplorar(String nombreCarpeta, int tamaño, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(true, carpetaLimitada.explorar().contains(mensaje));
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyEliminar(String nombreCarpeta, int tamaño, String nombreTexto, String contenidoTexto)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());

		carpetaLimitada.eliminar(mensaje);

		assertEquals(0, carpetaLimitada.obtenerTamaño());
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
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param tamaño         Categoria: int cualquiera. Representantes: Generados
	 *                       automaticamente > 0.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerHijoMensaje(String nombreCarpeta, int tamaño, String nombreTexto,
			String contenidoTexto) throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));

		carpetaLimitada.añadir(mensaje);

		assertEquals(mensaje, carpetaLimitada.obtenerHijo(0));
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
	 * @param nombreCarpeta      Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * @param tamaño             Categoria: int cualquiera. Representantes:
	 *                           Generados automaticamente > 0.
	 * @param nombreCarpetaPadre Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testPropertyObtenerPadre(String nombreCarpeta, int tamaño, String nombreCarpetaPadre)
			throws OperacionInvalida {

		assumeThat(tamaño, greaterThan(0));

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);
		Carpeta carpetaPadre = new Carpeta(nombreCarpetaPadre);

		carpetaLimitada.establecerPadre(carpetaPadre);

		assertEquals(carpetaPadre, carpetaLimitada.obtenerPadre());
	}
}
