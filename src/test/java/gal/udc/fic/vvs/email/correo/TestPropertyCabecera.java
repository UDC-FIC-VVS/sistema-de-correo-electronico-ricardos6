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
public class TestPropertyCabecera {

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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Property
	public void testPropertyObtenerRuta(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerRuta());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyObtenerRutaConPadre(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera, String nombreCarpeta) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		carpeta.añadir(correo);

		assertEquals(carpeta.obtenerPreVisualizacion() + " > " + correo.obtenerPreVisualizacion(),
				correo.obtenerRuta());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyObtenerPadre(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera, String nombreCarpeta) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);
		Carpeta carpeta = new Carpeta(nombreCarpeta);

		carpeta.añadir(correo);

		assertEquals(carpeta, correo.obtenerPadre());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyEstablecerLeido(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(1, correo.obtenerNoLeidos());

		correo.establecerLeido(true);

		assertEquals(0, correo.obtenerNoLeidos());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyObtenerNoLeido(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(1, correo.obtenerNoLeidos());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(mensaje.obtenerTamaño() + nombreCabecera.length() + valorCabecera.length(),
				correo.obtenerTamaño());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyObtenerIcono(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyPreVisualizacion(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(mensaje.obtenerPreVisualizacion(), correo.obtenerPreVisualizacion());
	}

	/**
	 * /**
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
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * 
	 * @throws OperacionInvalida Categoria: String cualquiera. Representantes:
	 *                           Generados automaticamente.
	 */
	@Property
	public void testPropertyVisualizacion(String nombreTexto, String contenidoTexto, String nombreCabecera,
			String valorCabecera) throws OperacionInvalida {

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(nombreCabecera + ": " + valorCabecera + "\n" + mensaje.obtenerVisualizacion(),
				correo.obtenerVisualizacion());
	}
}
