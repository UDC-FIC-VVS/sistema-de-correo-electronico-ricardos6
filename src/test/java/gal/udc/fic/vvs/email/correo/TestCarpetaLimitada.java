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
	public void testBuscarNombreCarpeta() throws OperacionInvalida {

		String nombreCarpeta = "nombreCarpeta";
		int tamaño = 20;
		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje = new Mensaje(texto);

		carpetaLimitada.añadir(mensaje);

		assertEquals(1, carpetaLimitada.buscar("e").size());
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
	public void testBuscarDemasiadogrande() throws OperacionInvalida {

		String nombreCarpeta = "nombreCarpeta";
		int tamaño = 1;
		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";

		Carpeta carpeta = new Carpeta(nombreCarpeta);
		CarpetaLimitada carpetaLimitada = new CarpetaLimitada(carpeta, tamaño);

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje = new Mensaje(texto);
		
		Texto texto2 = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje2 = new Mensaje(texto2);
		
		Texto texto3 = new Texto(nombreTexto, contenidoTexto);
		Mensaje mensaje3 = new Mensaje(texto3);

		carpetaLimitada.añadir(mensaje);
		carpetaLimitada.añadir(mensaje2);
		carpetaLimitada.añadir(mensaje3);

		assertEquals(2, carpetaLimitada.buscar("e").size());
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
