package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.regex.PatternSyntaxException;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;

public class TestAdjunto {

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testExplorar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Correo correo = new Adjunto(mensaje, archivo);

		correo.explorar();
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testAñadir() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Mensaje mensaje2 = new Mensaje(new Texto("", ""));

		Correo correo = new Adjunto(mensaje, archivo);

		correo.añadir(mensaje2);
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testEliminar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Correo correo = new Adjunto(mensaje, archivo);

		correo.eliminar(mensaje);
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida
	 */
	@Test(expected = OperacionInvalida.class)
	public void testObtenerHijo() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);

		Correo correo = new Adjunto(mensaje, archivo);

		correo.obtenerHijo(0);
	}

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
	 * No puedo probarlo con propiedades poqeu no podemos asegurar que el caracter
	 * "(" no aparecera en el contenido del texto
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida, PatternSyntaxException
	 */
	@Test
	public void testBuscar() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "contenidoTexto";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		assertEquals(true, correo.buscar(contenidoTexto).contains(correo));
	}

	/**
	 * 
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * negativas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Este metodo devuuelve un error en el caso de que el contenido del texto
	 * contenga el elemento (
	 * 
	 * @param nombreTexto    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoTexto Categoria: String cualquiera. Representantes: Caracter
	 *                       "(".
	 * @param nombreAudio    Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * @param contenidoAudio Categoria: String cualquiera. Representantes: String
	 *                       pequeño.
	 * 
	 * @throws OperacionInvalida, PatternSyntaxException
	 */
	@Test(expected = PatternSyntaxException.class)
	public void testBuscarEspacios() throws OperacionInvalida {

		String nombreTexto = "nombreTexto";
		String contenidoTexto = "(";
		String nombreAudio = "nombreAudio";
		String contenidoAudio = "contenidoAudio";

		Texto texto = new Texto(nombreTexto, contenidoTexto);
		MensajeAbstracto mensaje = new Mensaje(texto);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo correo = new Adjunto(mensaje, archivo);

		correo.buscar(contenidoTexto).contains(correo);
	}
}
