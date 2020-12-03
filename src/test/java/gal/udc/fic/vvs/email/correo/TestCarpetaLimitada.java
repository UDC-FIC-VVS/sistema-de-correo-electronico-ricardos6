package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpetaLimitada {
	
	
	/**
	 * Se crea una CarpetaLimitada dentro de una carpeta Padre
	 * y obtenem la  ruta de la carpeta limitada
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerRuta() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpetaPadre = new Carpeta("Carpeta Padre");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 10);
		
		carpetaPadre.añadir(carpeta);
	
		assertEquals("Carpeta Padre > Carpeta", carpetaLimitada.obtenerRuta());
	}
	
	/**
	 * Creamos un Mensaje con Texto dentro de una Carpeta Limitada
	 * Al ejecutar EstablecerLeido() sobre la carpeta, el mensaje deberia de marcarse como leido
	 * entonces al obtener los correos no leidos deberia de devolvernos 0
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testEstablecerLeido() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 10);
		
		carpetaLimitada.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));		
		
		carpetaLimitada.establecerLeido(true);
		
		assertEquals(0, carpetaLimitada.obtenerNoLeidos());
	}
	
	/**
	 * EL mismo caso que el anterior pero no estableciendo al carpeta como leido
	 * Aqui la funcion obtener no leidos deberia de devolver 1
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerNoLeido() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpetaPadre = new Carpeta("Carpeta Padre");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		carpetaLimitada.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));
		
		carpetaPadre.añadir(carpeta);
		
		assertEquals(1, carpetaLimitada.obtenerNoLeidos());
	}
	
	/**
	 * Creamos un Mensaje con Texto dentro de una Carpeta Limitada
	 * El tamaño de la carpeta es el mismo que el del texto ya que es el unico elemento dentro de ella
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		
		carpetaLimitada.añadir(new Mensaje(texto));
				
		assertEquals(texto.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
	}
	
	/**
	 * Obtenemos el icono de carpeta
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
				
		assertEquals(Correo.ICONO_CARPETA, carpetaLimitada.obtenerIcono());
	}
	
	/**
	 *  Obtenemos la previsualizacion de una Carpeta Limitada con un mensaje de Texto
	 *  en su interior
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerPrevisualización() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		
		carpetaLimitada.añadir(new Mensaje(texto));
				
		assertEquals("Carpeta (1)", carpetaLimitada.obtenerPreVisualizacion());
	}
	
	/**
	 *  Obtenemos la visualizacion de una Carpeta Limitada con un mensaje de Texto
	 *  en su interior
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerVisualización() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		
		carpetaLimitada.añadir(new Mensaje(texto));
				
		assertEquals("Carpeta (1)", carpetaLimitada.obtenerVisualizacion());
	}
	
	/**
	 *  Exploramos una Carpeta Limitada con un mensaje con Texto
	 *  Por lo que btenemos una lista con el mensaje
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testExplorar() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLimitada.añadir(mensaje);
				
		assertEquals(true, carpetaLimitada.explorar().contains(mensaje));
	}
	
	/**
	 *  Buscamos contenido dentro de una carpeta
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testBuscar() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLimitada.añadir(mensaje);
				
		assertEquals(true, carpetaLimitada.buscar("correo").contains(mensaje));
	}
	
	/**
	 *  Añadimos un mensaje y lo eliminamos
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testEliminar() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLimitada.añadir(mensaje);
				
		assertEquals(mensaje.obtenerTamaño(), carpetaLimitada.obtenerTamaño());
		
		carpetaLimitada.eliminar(mensaje);
		
		assertEquals(0, carpetaLimitada.obtenerTamaño());
	}
	
	/**
	 *  Obtenemos el correo hijo de la carpeta limitada
	 *  
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerHijo() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		
		carpetaLimitada.añadir(mensaje);
				
		assertEquals(mensaje, carpetaLimitada.obtenerHijo(0));
	}

	/**
	 *  Obtenemos el correo hijo de la carpeta limitada pero no tiene hijo
	 *  
	 * @throws OperacionInvalida
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testObtenerHijoNoHay() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		carpetaLimitada.obtenerHijo(0);
	}
	
	/**
	 * Creamos la carpeta limitada dentro de una carpeta normal
	 * Al obtener el padre de la carpeta limitada obtenemos la carpeta normal
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpetaPadre = new Carpeta("Carpeta Padre");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		carpetaLimitada.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));
		
		carpetaPadre.añadir(carpeta);
		
		assertEquals(carpetaPadre, carpetaLimitada.obtenerPadre());
	}
	
	/**
	 * Creamos la carpeta limitada dentro de una carpeta normal
	 * Al obtener el padre de la carpeta limitada obtenemos la carpeta normal
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testEstablecerPadre() throws OperacionInvalida  {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpetaPadre = new Carpeta("Carpeta Padre");
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, 40);
		
		carpetaLimitada.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));
		
		carpetaLimitada.establecerPadre(carpetaPadre);
		
		assertEquals(carpetaPadre, carpetaLimitada.obtenerPadre());
	}
}
