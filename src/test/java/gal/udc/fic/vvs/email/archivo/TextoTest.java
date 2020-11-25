package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {
	
	@Test
	 public void testObtenerNombre() {
		 
		 String nombreTexto = "Nombre Texto";
		 String contenido = "Contenido Texto";
		 Texto texto = new Texto(nombreTexto, contenido);
		 
		 assertEquals(nombreTexto, texto.obtenerNombre());
	 }
	 
	 @Test
	 public void testObtenerContenido() {
		 
		 String nombreTexto = "Nombre Texto";
		 String contenidoTexto = "Contenido Texto";
		 Texto texto = new Texto(nombreTexto, contenidoTexto);
		 
		 assertEquals(contenidoTexto, texto.obtenerContenido());
	 }
	 
	 @Test
	 public void testObtenerTamaño() {
		 
		 String nombreTexto = "Nombre Texto";
		 String contenido = "Contenido Texto";
		 Texto texto = new Texto(nombreTexto, contenido);
		 
		 assertEquals(contenido.length(), texto.obtenerTamaño());
	 }
	 
	 @Test
	 public void testObtenerPreVisualizacion() {
		 
		 String nombreTexto = "Nombre Texto";
		 String contenido = "Contenido Texto";
		 Texto texto = new Texto(nombreTexto, contenido);
		 
		 assertEquals(nombreTexto + "(" + texto.obtenerTamaño() + " bytes, " +  texto.obtenerMimeType() + ")", texto.obtenerPreVisualizacion());
	 }
}
