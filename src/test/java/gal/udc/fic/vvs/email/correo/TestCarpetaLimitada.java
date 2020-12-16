package gal.udc.fic.vvs.email.correo;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TestCarpetaLimitada {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Probamos que si buscamos un string que esta contenido en el mensaje de una
	 * carpeta y es menor que el tamaño de la carpeta limitada se devuelve.
	 * 
	 * @param nombreCarpeta  Categoria: String cualquiera. Representantes: String
	 *                       "nombreCarpeta".
	 * @param tamaño         Categoria: int cualquiera. Representantes: int 20.
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       "nombreTexto".
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       "contenidoTexto".
	 * 
	 * @throws OperacionInvalida
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		String nombreCarpeta = "nombreCarpeta";
		int tamaño = 20;
		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje = new Mensaje(texto);

		carpetaLimitada.añadir(mensaje);

		assertEquals(true, carpetaLimitada.buscar("texto").contains(mensaje));
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativa</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Probamos que si no hay hijos y queremos obtener los hijos de una carpeta nos
	 * devuelve una excepcion
	 * 
	 * Probamos que si buscamos un string que esta contenido en el mensaje de una
	 * carpeta y es menor que el tamaño de la carpeta limitada se devuelve.
	 * 
	 * @param nombreCarpeta Categoria: String cualquiera. Representantes: String
	 *                      "nombreCarpeta".
	 * @param tamaño        Categoria: int cualquiera. Representantes: 20.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testObtenerHijoNoHay() throws OperacionInvalida {

		String nombreCarpeta = "nombreCarpeta";
		int tamaño = 10;

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		carpetaLimitada.obtenerHijo(0);
	}
}
