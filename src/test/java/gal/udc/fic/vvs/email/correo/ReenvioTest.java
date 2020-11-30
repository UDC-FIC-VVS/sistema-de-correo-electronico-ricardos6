package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {

	/**
	 * Obtener ruta de un reenvio
	 * 
	 */
	@Test
	public void testObtenerRuta() {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		assertEquals("Contido do correo electrónico pe...", correo.obtenerRuta());
	}

	/**
	 * Obtener ruta de un reenvio dentro de una carpeta
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerRutaConPadre() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(correo);

		assertEquals("Carpeta (1) > Contido do correo electrónico pe...", correo.obtenerRuta());
	}

	/**
	 * Intentamos explorar un reenvio, no se puede
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(correo);

		correo.explorar();
	}

	/**
	 * Intentamos añadir un correo al reenvio, no se puede
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");

		correo.añadir(correo);
	}

	/**
	 * Intentamos eliminar un correo de dentro de un reenvio, no se puede
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");

		correo.eliminar(correo);
	}

	/**
	 * Intentamos obtener hijo de dentro de un reenvio, no se puede
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");

		correo.obtenerHijo(0);
	}

	/**
	 * Obtener padre del reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerPadre() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		Carpeta carpeta = new Carpeta("Carpeta");
		carpeta.añadir(correo);

		assertEquals(carpeta, correo.obtenerPadre());
	}

	/**
	 * Establecer como leido un reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testEstablecerLeido() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		assertEquals(1, correo.obtenerNoLeidos());

		correo.establecerLeido(true);

		assertEquals(0, correo.obtenerNoLeidos());
	}

	/**
	 * Obtener reenvio no leido
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerNoLeidos() throws OperacionInvalida {

		Correo correo = new Reenvio(
				new Cabecera(new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
						"Para", "lcastro@udc.es"), "De", "vvs@fic.udc.es"),
				new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));

		assertEquals(1, correo.obtenerNoLeidos());
	}

	/**
	 * Obtener tamaño de un reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerTamaño() throws OperacionInvalida {

		Texto texto = new Texto("contido", "Contido do correo electrónico familiar 1.");
		Mensaje mensaje = new Mensaje(texto);

		Texto texto2 = new Texto("contido", "Contido do correo electrónico persoal 1.");
		Mensaje mensaje2 = new Mensaje(texto2);
		Cabecera cabecera = new Cabecera(mensaje2, "Para", "lcastro@udc.es");
		Cabecera cabecera2 = new Cabecera(cabecera, "De", "vvs@fic.udc.es");

		Correo correo = new Reenvio(cabecera2, mensaje);

		assertEquals(mensaje.obtenerTamaño() + cabecera2.obtenerTamaño(), correo.obtenerTamaño());
	}

	/**
	 * Obtener tamaño de un reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerIcono() throws OperacionInvalida {

		Texto texto = new Texto("contido", "Contido do correo electrónico familiar 1.");
		Mensaje mensaje = new Mensaje(texto);

		Texto texto2 = new Texto("contido", "Contido do correo electrónico persoal 1.");
		Mensaje mensaje2 = new Mensaje(texto2);
		Cabecera cabecera = new Cabecera(mensaje2, "Para", "lcastro@udc.es");
		Cabecera cabecera2 = new Cabecera(cabecera, "De", "vvs@fic.udc.es");

		Correo correo = new Reenvio(cabecera2, mensaje);

		assertEquals(Correo.ICONO_NUEVO_MENSAJE, correo.obtenerIcono());
	}

	/**
	 * Obtener previsualizavcion de un reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerPreVisualizacion() throws OperacionInvalida {

		Texto texto = new Texto("contido", "Contido do correo electrónico familiar 1.");
		Mensaje mensaje = new Mensaje(texto);

		Texto texto2 = new Texto("contido", "Contido do correo electrónico persoal 1.");
		Mensaje mensaje2 = new Mensaje(texto2);
		Cabecera cabecera = new Cabecera(mensaje2, "Para", "lcastro@udc.es");
		Cabecera cabecera2 = new Cabecera(cabecera, "De", "vvs@fic.udc.es");

		Correo correo = new Reenvio(cabecera2, mensaje);

		assertEquals("Contido do correo electrónico pe...", correo.obtenerPreVisualizacion());
	}

	/**
	 * Obtener visualizavcion de un reenvio
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testObtenerVisualizacion() throws OperacionInvalida {

		Texto texto = new Texto("contido", "Contido do correo electrónico familiar 1.");
		Mensaje mensaje = new Mensaje(texto);
		
		Texto texto2 = new Texto("contido", "Contido do correo electrónico persoal 1.");
		Mensaje mensaje2 = new Mensaje(texto2);
		Cabecera cabecera = new Cabecera(mensaje2, "Para", "lcastro@udc.es");
		Cabecera cabecera2 = new Cabecera(cabecera, "De", "vvs@fic.udc.es");
		
		
		Correo correo = new Reenvio(cabecera2, mensaje);

		assertEquals(cabecera2.obtenerVisualizacion() +
				"\n\n---- Correo reenviado ----\n\n" + mensaje.obtenerVisualizacion() + "\n---- Fin correo reenviado ----"
		, correo.obtenerVisualizacion());
	}
	
	/**
	 * Busqueda de keywords en el contenido
	 * 
	 * @throws OperacionInvalida
	 * 
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		Texto texto = new Texto("contido", "Contido do correo electrónico familiar 1.");
		Mensaje mensaje = new Mensaje(texto);
		
		Texto texto2 = new Texto("contido", "Contido do correo electrónico persoal 1.");
		Mensaje mensaje2 = new Mensaje(texto2);
		Cabecera cabecera = new Cabecera(mensaje2, "Para", "lcastro@udc.es");
		Cabecera cabecera2 = new Cabecera(cabecera, "De", "vvs@fic.udc.es");
		
		
		Correo correo = new Reenvio(cabecera2, mensaje);

		assertEquals(true, correo.buscar("persoal").contains(correo));
		assertEquals(1, correo.buscar("persoal").size());
	}
}
