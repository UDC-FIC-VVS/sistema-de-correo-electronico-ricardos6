package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	@Test
	public void testObtenerTamaño() {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerTamaño() + archivo.obtenerTamaño(), correo.obtenerTamaño());
	}

	@Test
	public void testObtenerVisualizacion() {

		Texto texto = new Texto("nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio("nombre audio", "contenido audio");

		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(mensaje.obtenerVisualizacion() + "\n\nAdxunto: " + archivo.obtenerPreVisualizacion(),
				correo.obtenerVisualizacion());
	}
}
