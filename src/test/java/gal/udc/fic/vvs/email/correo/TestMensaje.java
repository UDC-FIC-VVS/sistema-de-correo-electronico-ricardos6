package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestMensaje {
	
	@Test
	public void testLeidoYObtener() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		
		assertEquals(1, mensaje.obtenerNoLeidos());
		
		mensaje.establecerLeido(true);
		
		assertEquals(0, mensaje.obtenerNoLeidos());
	}
	
	@Test
	public void testObtenerTamaño() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		
		assertEquals(texto.obtenerTamaño(), mensaje.obtenerTamaño());
	}
	
	@Test
	public void testObtenerIcono() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, mensaje.obtenerIcono());
		
		mensaje.establecerLeido(true);
		
		assertEquals(Correo.ICONO_MENSAJE, mensaje.obtenerIcono());
	}
	
	@Test
	public void testObtenerPreVisualizacion() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		
		assertEquals("Contenido texto...", mensaje.obtenerPreVisualizacion());
	}

	@Test
	public void testBuscar() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		
		assertEquals(1, mensaje.buscar("texto").size());
		assertEquals(true, mensaje.buscar("texto").contains(mensaje));
	}
	
	@Test
	public void testBuscarNoEncuentra() {
		
		Texto texto = new Texto("Nombre Texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		
		assertEquals(true, mensaje.buscar("no encuentra").isEmpty());
	}
}
