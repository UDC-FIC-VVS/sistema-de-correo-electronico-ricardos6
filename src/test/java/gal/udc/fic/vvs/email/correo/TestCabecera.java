package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCabecera {

	/**
	 * Obtenemos ruta de una Cabecera
	 * Debe de devolvernos solo la previsualizacion del correo
	 */
	@Test
	public void testObtenerRuta() {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		assertEquals("Contenido texto...", correo.obtenerRuta());
	}
	
	/**
	 * Obtenemos ruta de una Cabecera dentro de una carpeta
	 * Debe de devolvernos la ruta de Carpeta (1) y dentro la cabecera
	 */
	@Test
	public void testObtenerRutaConPadre() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(correo);
		
		assertEquals("Carpeta (1) > Contenido texto...", correo.obtenerRuta());
	}
	
	/**
	 * Intentamos explorar una cabecera
	 * pero al no poder contener correos, la operacion es invalidaa
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		correo.explorar();
	}
	
	/**
	 * Intentamos añadir un correo a una cabecera
	 * pero al no poder contener correos, la operacion es invalidaa
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		MensajeAbstracto mensajeAñadir = new Mensaje(new Texto("Mensaje a añadir", "Contenido mensaje a añadir"));
		
		correo.añadir(mensajeAñadir);
	}
	
	/**
	 * Intentamos eliminar un correo a una cabecera
	 * pero al no poder contener correos, la operacion es invalidaa
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		MensajeAbstracto mensajeEliminar = new Mensaje(new Texto("Mensaje a añadir", "Contenido mensaje a añadir"));
		
		correo.eliminar(mensajeEliminar);
	}
	
	/**
	 * Intentamos obtener un hijo de una cabecera
	 * pero al no poder contener correos, la operacion es invalidaa
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		correo.obtenerHijo(0);
	}
	
	/**
	 * Obtenemos padre de una Cabecera
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(correo);
		
		assertEquals(carpeta, correo.obtenerPadre());
	}
	
	/**
	 * Establecemos como leido una cabecera
	 */
	@Test
	public void testEstablecerLeido() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		assertEquals(1, correo.obtenerNoLeidos());
		
		correo.establecerLeido(true);
		
		assertEquals(0, correo.obtenerNoLeidos());
	}
	
	/**
	 * Obtenemos cabecera no leida
	 */
	@Test
	public void testObtenerNoLeido() throws OperacionInvalida {
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, "Cabecera", "Numero 1");
		
		assertEquals(1, correo.obtenerNoLeidos());
	}
	
	/**
	 * Obtenemos tamaño de una cabecera
	 * que es igual al tamaño del mensaje que tiene + el tamaño del nombre de la cabecera +
	 * el tamaño del valor de la cabecera
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {
		
		String nombre = "Nombre Cabecera";
		String valor = "Valor Cabecera";
		
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(mensaje.obtenerTamaño() + nombre.length() + valor.length(), correo.obtenerTamaño());
	}
	
	/**
	 * Obtenemos icono de una cabecera , que sera el icono de mensaje nuevo
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {
		
		String nombre = "Nombre Cabecera";
		String valor = "Valor Cabecera";
		
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
	}
	
	/**
	 * Obtenemos previcualizacion de una cabecera que sera el contenido del mensaje que contiene
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {
		
		String nombre = "Nombre Cabecera";
		String valor = "Valor Cabecera";
		
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombre, valor);
		
		assertEquals("Contenido texto...", correo.obtenerPreVisualizacion());
	}
	
	/**
	 * Obtenemos vicualizacion de una cabecera que sera la composicion de la visulizacion de la cabecera
	 * + la visualizacion del mensaje
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {
		
		String nombre = "Nombre Cabecera";
		String valor = "Valor Cabecera";
		
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(nombre + ": " + valor + "\n" + mensaje.obtenerVisualizacion(), correo.obtenerVisualizacion());
	}
	
	/**
	 * Buscamos en la cabecera una keyword que aparezca en el contenido del mensjae que contiene la cabecera
	 * y se devuelve la cabecera
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {
		
		String nombre = "Nombre Cabecera";
		String valor = "Valor Cabecera";
		
		Texto texto = new Texto("Nombre", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombre, valor);
		
		assertEquals(true, correo.buscar("texto").contains(correo));
	}
}
