package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

/**
 * 
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestPropertyImagen {

	/**
	 * - Nivel da prueba: Unitaria
	 * - Categorías a las que pertenece: Funcionales dinámicas de caja negra, positivas
	 * - Mecanismo de selección de los datos: 
	 * 		Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * 		generados automaticamente.
	 * 
	 */
	@Property
	public void testPropertyObtenerNombre(String nombre, String contenido) {
		
		Archivo archivo = new Imagen(nombre, contenido);
	
		assertEquals(nombre, archivo.obtenerNombre());
	}
	
	/**
	 * - Nivel da prueba: Unitaria
	 * - Categorías a las que pertenece: Funcionales dinámicas de caja negra, positivas
	 * - Mecanismo de selección de los datos: 
	 * 		Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * 		generados automaticamente.
	 * 
	 */
	@Property
	public void testPropertyObtenerContenido(String nombre, String contenido) {
		
		Archivo archivo = new Imagen(nombre, contenido);
	
		assertEquals(contenido, archivo.obtenerContenido());
	}
	
	/**
	 * - Nivel da prueba: Unitaria
	 * - Categorías a las que pertenece: Funcionales dinámicas de caja negra, positivas
	 * - Mecanismo de selección de los datos: 
	 * 		Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * 		generados automaticamente.
	 * 
	 */
	@Property
	public void testPropertyObtenerTamaño(String nombre, String contenido) {
		
		Archivo archivo = new Imagen(nombre, contenido);
	
		assertEquals(contenido.length(), archivo.obtenerTamaño());
	}
	
	/**
	 * - Nivel da prueba: Unitaria
	 * - Categorías a las que pertenece: Funcionales dinámicas de caja negra, positivas
	 * - Mecanismo de selección de los datos: 
	 * 		Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * 		generados automaticamente.
	 * 
	 */
	@Property
	public void testPropertyObtenerPreVisualizacion(String nombre, String contenido) {

		Archivo archivo = new Imagen(nombre, contenido);

		assertEquals(nombre + "(" + archivo.obtenerTamaño() + " bytes, " + archivo.obtenerMimeType() + ")",
				archivo.obtenerPreVisualizacion());
	}
	
	/**
	 * Nivel da prueba: Unitaria Categorías a las que pertenece: Funcionales
	 * dinámicas de caja negra, positivas Mecanismo de selección de los datos:
	 * Categoria: Strings cualesquiera. Como representate elegimos dos String
	 * generados automaticamente.
	 * 
	 */
	@Property
	public void testPropertyObtenerMime(String nombre, String contenido) {

		Archivo archivo = new Imagen(nombre, contenido);

		assertEquals("image/png", archivo.obtenerMimeType());
	}
}
