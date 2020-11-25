package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {
	
	@Test
	public void testObtenerNombre() {
		
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 10;
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(nombreArchivadorSimple, archivadorSimple.obtenerNombre());
	}
	
	@Test
	public void testAlmacenarCorreo() {
		
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 25;
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		Texto texto = new Texto("Nombre Texto", "Contenido Texto");
		
		Correo correo = new Mensaje(texto);
		
		assertEquals(true, archivadorSimple.almacenarCorreo(correo));
		
		assertEquals(espacio - texto.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());
	}
	
	@Test
	public void testObtenerEspacioTotal() {
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 10;
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(espacio, archivadorSimple.obtenerEspacioTotal());
	}
	
	@Test
	public void testObtenerEspacioDisponible() {
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 10;
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(espacio, archivadorSimple.obtenerEspacioDisponible());
	}
}
