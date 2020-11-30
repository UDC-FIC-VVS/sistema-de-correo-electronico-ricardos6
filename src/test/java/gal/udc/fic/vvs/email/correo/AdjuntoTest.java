package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	/**
	 * Obtenemos el tamaño de un correo con un audio y texto adjunto
	 */
	@Test
	public void testObtenerTamaño() {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerTamaño() + archivo.obtenerTamaño(), correo.obtenerTamaño());
	}

	/**
	 * Visualizacion de un correo con un memensaje con un audio adjunto
	 */
	@Test
	public void testObtenerVisualizacion() {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + archivo.obtenerPreVisualizacion(),
				correo.obtenerVisualizacion());
	}

	/**
	 * Ruta de un adjunto
	 */
	@Test
	public void testObtenerRuta() {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals("Contenido texto...", correo.obtenerRuta());
	}
	
	/**
	 * Ruta de un adjunto dentro de una carpeta
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testObtenerRutaConPadre() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		Carpeta carpeta = new Carpeta("carpeta");
		carpeta.añadir(correo);
		
		assertEquals("carpeta (1) > Contenido texto...", correo.obtenerRuta());
	}
	
	/**
	 * Intentar explorar un correo correo adjunto
	 * 
	 * @throws OperacionInvalida 
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		correo.explorar();
	}
	
	/**
	 * Intentar aladir un correo al correo cn adjunto
	 * 
	 * @throws OperacionInvalida 
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Mensaje mensaje2 = new Mensaje(new Texto("", ""));

		Correo correo = new Adjunto(mensaje, archivo);

		correo.añadir(mensaje2);
	}
	
	/**
	 * Intentar eliminar un correo de un adjunto
	 * pero un adjunto no puede tener hijos
	 * 
	 * @throws OperacionInvalida 
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Mensaje mensaje2 = new Mensaje(new Texto("", ""));

		Correo correo = new Adjunto(mensaje, archivo);

		correo.eliminar(mensaje2);
	}
	
	/**
	 * Intentar obtener hijo de un adjunto
	 * 
	 * @throws OperacionInvalida 
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Mensaje mensaje2 = new Mensaje(new Texto("", ""));

		Correo correo = new Adjunto(mensaje, archivo);

		correo.obtenerHijo(0);
	}
	
	/**
	 * Establecer como leido el adjunto
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testEstablecerLeido() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		
		correo.establecerLeido(true);
		
		assertEquals(0, correo.obtenerNoLeidos());
	}
	
	/**
	 * Obtener si esta como leido el adjunto
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testObtenerNoLeidos() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		
		assertEquals(1, correo.obtenerNoLeidos());
	}
	
	/**
	 * Obtener icono del adjunto cuando no esta leido
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
	}
	
	/**
	 * Obtener previsualizacion de adjunto
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		
		assertEquals("Contenido texto...", correo.obtenerPreVisualizacion());
	}
	
	/**
	 * Obtener padre de adjunto
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testObtenePadre() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		Carpeta carpeta = new Carpeta("Carpeta");
		
		carpeta.añadir(correo);
		
		assertEquals(carpeta, correo.obtenerPadre());
	}
	
	/**
	 * Obtener padre de adjunto
	 * 
	 * @throws OperacionInvalida 
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");
		Correo correo = new Adjunto(mensaje, archivo);
		Carpeta carpeta = new Carpeta("Carpeta");
		
		carpeta.añadir(correo);
		
		assertEquals(true, correo.buscar("texto").contains(correo));
	}
}
