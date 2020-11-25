package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {

	@Test
	public void testLog() {
		
		String nombreArchivador = "Archivador";
		int espacio = 25;
		
		Archivador archivador = new ArchivadorSimple(nombreArchivador, espacio);
		Delegado delegado = new Delegado(archivador);
		
		Log log = new Log(delegado);
		
		Texto texto = new Texto("Nombre Texto", "Contenido Texto");		
		Correo correo = new Mensaje(texto);
		
		assertEquals(true, log.almacenarCorreo(correo));
		
		assertEquals(espacio - texto.obtenerTamaño(), log.obtenerEspacioDisponible());
		assertEquals(nombreArchivador, log.obtenerNombre());
	
		log.establecerDelegado(delegado);
		
		assertEquals(delegado, log.obtenerDelegado());
	}
}
