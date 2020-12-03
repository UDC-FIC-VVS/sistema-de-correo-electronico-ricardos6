package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestImagen {
	@Test
	 public void testObtenerNombre() {
		 
		 String nombreImagen = "Nombre Imagen";
		 String contenido = "Contenido Imagen";
		 Imagen imagen = new Imagen(nombreImagen, contenido);
		 
		 assertEquals(nombreImagen, imagen.obtenerNombre());
	 }
	 
	 @Test
	 public void testObtenerContenido() {
		 
		 String nombreImagen = "Nombre Imagen";
		 String contenidoImagen = "Contenido Imagen";
		 Imagen imagen = new Imagen(nombreImagen, contenidoImagen);
		 
		 assertEquals(contenidoImagen, imagen.obtenerContenido());
	 }
	 
	 @Test
	 public void testObtenerTamaño() {
		 
		 String nombreImagen = "Nombre Imagen";
		 String contenido = "Contenido Imagen";
		 Imagen imagen = new Imagen(nombreImagen, contenido);
		 
		 assertEquals(contenido.length(), imagen.obtenerTamaño());
	 }
	 
	 @Test
	 public void testObtenerPreVisualizacion() {
		 
		 String nombreImagen = "Nombre Imagen";
		 String contenido = "Contenido Imagen";
		 Imagen imagen = new Imagen(nombreImagen, contenido);
		 
		 assertEquals(nombreImagen + "(" + imagen.obtenerTamaño() + " bytes, " +  imagen.obtenerMimeType() + ")", imagen.obtenerPreVisualizacion());
	 }
}
