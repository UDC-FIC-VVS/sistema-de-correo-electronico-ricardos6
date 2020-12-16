package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
public class TestReenvio {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Operacion no valida de Reenvio
	 * 
	 * @param nombreTexto:    Categoria: String cualquiera. Representantes: String
	 *                        "nombreTexto".
	 * @param contenidoTexto: Categoria: String cualquiera. Representantes: String
	 *                        "contenidoTexto.
	 * @param nombreCabecera: Categoria: String cualquiera. Representantes: String
	 *                        "nombreCabecera".
	 * @param valorCabecera:  Categoria: String cualquiera. Representantes: String
	 *                        "valorCabecera".
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabercera";
		String valorCabecera = "valorCabecera";

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		correo.explorar();
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Operacion no valida de Reenvio
	 * 
	 * @param nombreTexto:    Categoria: String cualquiera. Representantes: String
	 *                        "nombreTexto".
	 * @param contenidoTexto: Categoria: String cualquiera. Representantes: String
	 *                        "contenidoTexto.
	 * @param nombreCabecera: Categoria: String cualquiera. Representantes: String
	 *                        "nombreCabecera".
	 * @param valorCabecera:  Categoria: String cualquiera. Representantes: String
	 *                        "valorCabecera".
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabercera";
		String valorCabecera = "valorCabecera";

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		correo.añadir(correo);
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Operacion no valida de Reenvio
	 * 
	 * @param nombreTexto:    Categoria: String cualquiera. Representantes: String
	 *                        "nombreTexto".
	 * @param contenidoTexto: Categoria: String cualquiera. Representantes: String
	 *                        "contenidoTexto.
	 * @param nombreCabecera: Categoria: String cualquiera. Representantes: String
	 *                        "nombreCabecera".
	 * @param valorCabecera:  Categoria: String cualquiera. Representantes: String
	 *                        "valorCabecera".
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabercera";
		String valorCabecera = "valorCabecera";

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		correo.eliminar(correo);
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Operacion no valida de Reenvio
	 * 
	 * @param nombreTexto:    Categoria: String cualquiera. Representantes: String
	 *                        "nombreTexto".
	 * @param contenidoTexto: Categoria: String cualquiera. Representantes: String
	 *                        "contenidoTexto.
	 * @param nombreCabecera: Categoria: String cualquiera. Representantes: String
	 *                        "nombreCabecera".
	 * @param valorCabecera:  Categoria: String cualquiera. Representantes: String
	 *                        "valorCabecera".
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabercera";
		String valorCabecera = "valorCabecera";

		MensajeAbstracto mensaje = new Mensaje(new Texto(nombreTexto, contenidoTexto));
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		correo.obtenerHijo(0);
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param nombreCabecera Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 * @param valorCabecera  Categoria: String cualquiera. Representantes: Generados
	 *                       automaticamente.
	 */
	@Test
	public void testBuscar() {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreCabecera = "nombreCabercera";
		String valorCabecera = "valorCabecera";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje = new Mensaje(texto);
		Cabecera cabecera = new Cabecera(mensaje, nombreCabecera, valorCabecera);

		Correo correo = new Reenvio(cabecera, mensaje);

		assertEquals(true, correo.buscar(contenidoTexto.substring(1, 3)).contains(correo));
		assertEquals(1, correo.buscar(contenidoTexto.substring(1, 3)).size());
	}
}
