package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {
	
	/**
	 * Añadimos un mensaje a la carpeta y comprobamos su tamaño
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testAñadir() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		
		carpeta.añadir(new Mensaje(texto));
				
		assertEquals(texto.obtenerTamaño(), carpeta.obtenerTamaño());
	}
	
	/**
	 * Añadimos un mensaje que ya esta dentro de una carpeta en otra carpeta.
	 * La primera carpeta se elimina como padre del mensaje y se establece la nueva
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testAñadirCarpetaHijo() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpeta2 = new Carpeta("Carpeta Padre");		
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		
		carpeta.añadir(mensaje);
		carpeta2.añadir(mensaje);
				
		assertEquals(texto.obtenerTamaño(), carpeta2.obtenerTamaño());
		assertEquals(carpeta2, mensaje.obtenerPadre());
		assertEquals(mensaje, carpeta2.obtenerHijo(0));
	}
	
	/**
	 * Teniendo dos mensajes dentro de un carpeta establecemos como leido la carpeta
	 * y se establecen como leido sus correos
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testEstablecerLeido() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals(2, carpeta.obtenerNoLeidos());
		
		carpeta.establecerLeido(true);
				
		assertEquals(0, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Teniendo dos mensajes dentro de un carpeta establecemos como leido la carpeta
	 * y se establecen como leido sus correos
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerNoLeido() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals(2, carpeta.obtenerNoLeidos());
	}
	
	/**
	 * Teniendo dos mensajes dentro de un carpeta establecemos como leido la carpeta
	 * y se establecen como leido sus correos
	 * 
	 * @throws OperacionInvalida
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		
		assertEquals(new Integer(1), carpeta.obtenerIcono());
	}
	
	/**
	 * Obtenemos previsualizacion de una carpeta con 2 mensajes dentro
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals("Carpeta (2)", carpeta.obtenerPreVisualizacion());
	}
	
	/**
	 * Obtenemos visualizacion de una carpeta con 2 mensajes dentro
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals("Carpeta (2)", carpeta.obtenerVisualizacion());
	}
	
	/**
	 * Añadimos dos mensajes a la carpeta y los obtenemmos en una lista
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerHijos() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals(true, carpeta.explorar().contains(mensaje));
		assertEquals(true, carpeta.explorar().contains(mensaje2));
	}
	
	/**
	 * Obtenemos visualizacion de una carpeta con 2 mensajes dentro
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerBuscar() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		assertEquals(true, carpeta.buscar("o").contains(mensaje));
		assertEquals(true, carpeta.buscar("o").contains(mensaje2));
		assertEquals(2, carpeta.buscar("o").size());
	}
	
	/**
	 * Borramos uno de los mensajes que hay dentro de una carpeta
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testEliminar() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);
		
		carpeta.eliminar(mensaje2);
		
		assertEquals(true, carpeta.buscar("o").contains(mensaje));
		assertEquals(1, carpeta.buscar("o").size());
	}
	
	/**
	 * Borramos uno de los mensajes que hay dentro de una carpeta
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerHijo() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");	
		Texto texto = new Texto("contido", "Contido do correo electrónico.");
		Mensaje mensaje = new Mensaje(texto);
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(mensaje);
		carpeta.añadir(mensaje2);		
		
		assertEquals(mensaje, carpeta.obtenerHijo(0));
		assertEquals(mensaje2, carpeta.obtenerHijo(1));
	}
	
	/**
	 * Borramos uno de los mensajes que hay dentro de una carpeta
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerRuta() throws OperacionInvalida {
		
		Carpeta carpeta = new Carpeta("Carpeta");
		Carpeta carpeta2 = new Carpeta("Carpeta2");
		Mensaje mensaje2 = new Mensaje(new Texto("Nombre 2", "Texto 2"));
		
		carpeta.añadir(carpeta2);
		carpeta.añadir(mensaje2);		
		
		assertEquals("Carpeta (1) > Carpeta2", carpeta2.obtenerRuta());
	}
}
