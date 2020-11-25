package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {
	
	@Test	
	public void testAlmacenarCorreo() {
		
		String nombreArchivadorSimple = "Archivador Simple";
		int espacio = 25;
		
		ArchivadorSimple archivadorSimple = new ArchivadorSimple(nombreArchivadorSimple, espacio);
		
		Delegado delegado = new Delegado(archivadorSimple);
		
		Texto texto = new Texto("Nombre Texto", "Contenido Texto");
		
		Correo correo = new Mensaje(texto);
		
		assertEquals(true, delegado.almacenarCorreo(correo));
	}
	
	@Test
	public void testEstablecerYObtenerDelegado() {
		
		String nombreArchivador = "Archivador";
		int espacio = 25;
		
		Archivador archivador = new ArchivadorSimple(nombreArchivador, espacio);
		
		Delegado delegado = new Delegado(archivador);
		
		delegado.establecerDelegado(archivador);
		
		assertEquals(archivador, delegado.obtenerDelegado());
		
	}
}
