package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCabecera {

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Probamos el comportamiento de ObtenerRuta en el caso de qe el contenido del
	 * Texto sea vacio
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 */
	@Test
	public void testObtenerRuta() {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals("...", correo.obtenerRuta());
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Esta operacion no esta permitida en la clase Cabecera
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		correo.explorar();
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Esta operacion no esta permitida en la clase Cabecera
	 * 
	 * @param nombreTexto          Categoria: String cualquiera. Representantes:
	 *                             String "nombreTexto".
	 * @param contenidoTexto       Categoria: String cualquiera. Representantes:
	 *                             String vacio.
	 * @param nombreCabecera       Categoria: String cualquiera. Representantes:
	 *                             String "nombreCabecera".
	 * @param valorCabecera        Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 * @param nombreTextoAñadir    Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 * @param contenidoTextoAñadir Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";
		String nombreTextoAñadir = "nombreTextoAñadir";
		String contenidoTextoAñadir = "contenidoTextoAñadir";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		MensajeAbstracto mensajeAñadir = new Mensaje(new Texto(nombreTextoAñadir, contenidoTextoAñadir));

		correo.añadir(mensajeAñadir);
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Esta operacion no esta permitida en la clase Cabecera
	 * 
	 * @param nombreTexto          Categoria: String cualquiera. Representantes:
	 *                             String "nombreTexto".
	 * @param contenidoTexto       Categoria: String cualquiera. Representantes:
	 *                             String vacio.
	 * @param nombreCabecera       Categoria: String cualquiera. Representantes:
	 *                             String "nombreCabecera".
	 * @param valorCabecera        Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 * @param nombreTextoAñadir    Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 * @param contenidoTextoAñadir Categoria: String cualquiera. Representantes:
	 *                             String "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";
		String nombreTextoAñadir = "nombreTextoAñadir";
		String contenidoTextoAñadir = "contenidoTextoAñadir";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		MensajeAbstracto mensajeEliminar = new Mensaje(new Texto(nombreTextoAñadir, contenidoTextoAñadir));

		correo.eliminar(mensajeEliminar);
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Esta operacion no esta permitida en la clase Cabecera
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		correo.obtenerHijo(0);
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Porbamos que se obtiene null cuando intentas obtener el padre de un correo
	 * adjunto que no tiene padre
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test
	public void testObtenerPadreSiNoTiene() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(null, correo.obtenerPadre());
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * La funcion Buscar() no permite busqueda con caracter "{"
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test(expected = PatternSyntaxException.class)
	public void testBuscarCaracterNoValido() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "{";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(true, correo.buscar("{").contains(correo));
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positiva</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Probamos que siempre encuentra buscando por un sibstring del contenido del texto
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       vacio.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: String
	 *                       "nombreCabecera".
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: String
	 *                       "valorCabecera".
	 *
	 * @throws OperacionInvalida
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabecera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Correo correo = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		assertEquals(true, correo.buscar(contenidoTexto.substring(0, 2)).contains(correo));
	}
}
