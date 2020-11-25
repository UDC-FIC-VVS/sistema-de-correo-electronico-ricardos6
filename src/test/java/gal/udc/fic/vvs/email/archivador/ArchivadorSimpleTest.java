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
		
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(nombreArchivadorSimple, archivadorSimple.obtenerNombre());
	}
	
	@Test
	public void testAlmacenarCorreoDemasiadoGrande() {
		
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 5;
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		Texto texto = new Texto("Nombre Texto", "Contenido Texto");
		
		Correo correo = new Mensaje(texto);;
		
		assertEquals(false, archivadorSimple.almacenarCorreo(correo));
	}
	
	@Test
	public void testAlmacenarCorreo() {
		
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 25;
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		Texto texto = new Texto("Nombre Texto", "Contenido Texto");
		
		Correo correo = new Mensaje(texto);
		
		assertEquals(true, archivadorSimple.almacenarCorreo(correo));
		
		assertEquals(espacio, archivadorSimple.obtenerEspacioTotal());
		
		assertEquals(espacio - texto.obtenerTamaño(), archivadorSimple.obtenerEspacioDisponible());
	}
	
	@Test
	public void testObtenerEspacioTotal() {
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 10;
		
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(espacio, archivadorSimple.obtenerEspacioTotal());
	}
	
	@Test
	public void testObtenerEspacioDisponible() {
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 10;
		
		Archivador archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		assertEquals(espacio, archivadorSimple.obtenerEspacioDisponible());
	}
	
	@Test
	public void testObtenerDelegado() {
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 25;
		Archivador archivador = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		archivador.establecerDelegado(archivador);
		
		assertEquals(null, archivador.obtenerDelegado());
	}
}
