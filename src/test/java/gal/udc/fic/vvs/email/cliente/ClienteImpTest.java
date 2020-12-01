package gal.udc.fic.vvs.email.cliente;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivador.Archivador;
import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

public class ClienteImpTest {

	/**
	 * Creamos un cliente con un archivador, una carpeta y dentro un mensaje con texto.
	 * Miramos en la cobertura que usamos los metodos privados 
	 * No se como probar las acciones de click de raton, pero como nuestro oobjetivo no es probar la interfaz
	 * asumo que no hara falta probarlo
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = Test.None.class /* no exception expected */)
	public void testClienteCreacion() throws OperacionInvalida {
		
		Texto texto = new Texto("Nombre texto", "Contenido texto");
		MensajeAbstracto mensaje = new Mensaje(texto);
		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(mensaje);
		
		Cliente cliente = new ClienteImp(carpeta);
		
		Archivador archivador = new ArchivadorSimple("Archivador", 100);
		
		cliente.agregarArchivador(archivador);
	}
}
