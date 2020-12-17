package gal.udc.fic.vvs.email.integracion;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Adjunto;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;
import gal.udc.fic.vvs.email.correo.OperacionInvalida;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
@RunWith(JUnitQuickcheck.class)
public class TestIntegracionCorreoYArchivo {

	/**
	 * <ul>
	 * <li>Nivel da prueba: Integracion</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreCarpetaRaiz   Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo1  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo2  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo3  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoRaiz     Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoRaiz  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo1    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo1 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo3    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo3 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreAudio         Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoAudio      Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testIntegracionObtenerRutaCorreoHijo3(String nombreCarpetaRaiz, String nombreCarpetaHijo1,
			String nombreCarpetaHijo2, String nombreCarpetaHijo3, String nombreTextoRaiz, String contenidoTextoRaiz,
			String nombreTextoHijo1, String contenidoTextoHijo1, String nombreTextoHijo3, String contenidoTextoHijo3,
			String nombreAudio, String contenidoAudio) throws OperacionInvalida {

		Carpeta raiz = new Carpeta(nombreCarpetaRaiz);
		Carpeta hijo1 = new Carpeta(nombreCarpetaHijo1);
		Carpeta hijo2 = new Carpeta(nombreCarpetaHijo2);
		Carpeta hijo3 = new Carpeta(nombreCarpetaHijo3);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo mensajeRaiz = new Mensaje(new Texto(nombreTextoRaiz, contenidoTextoRaiz));
		Correo mensajeHijo1 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		MensajeAbstracto mensajeHijo3 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		Correo correoHijo3 = new Adjunto(mensajeHijo3, archivo);

		raiz.añadir(mensajeRaiz);
		hijo1.añadir(mensajeHijo1);
		hijo3.añadir(correoHijo3);
		hijo1.añadir(hijo3);
		raiz.añadir(hijo1);
		raiz.añadir(hijo2);

		assertEquals(
				raiz.obtenerPreVisualizacion() + " > " + hijo1.obtenerPreVisualizacion() + " > "
						+ hijo3.obtenerPreVisualizacion() + " > " + mensajeHijo3.obtenerPreVisualizacion(),
				correoHijo3.obtenerRuta());
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Integracion</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreCarpetaRaiz   Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo1  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo2  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo3  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoRaiz     Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoRaiz  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo1    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo1 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo3    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo3 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreAudio         Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoAudio      Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testIntegracionExplorar(String nombreCarpetaRaiz, String nombreCarpetaHijo1, String nombreCarpetaHijo2,
			String nombreCarpetaHijo3, String nombreTextoRaiz, String contenidoTextoRaiz, String nombreTextoHijo1,
			String contenidoTextoHijo1, String nombreTextoHijo3, String contenidoTextoHijo3, String nombreAudio,
			String contenidoAudio) throws OperacionInvalida {

		Carpeta raiz = new Carpeta(nombreCarpetaRaiz);
		Carpeta hijo1 = new Carpeta(nombreCarpetaHijo1);
		Carpeta hijo2 = new Carpeta(nombreCarpetaHijo2);
		Carpeta hijo3 = new Carpeta(nombreCarpetaHijo3);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo mensajeRaiz = new Mensaje(new Texto(nombreTextoRaiz, contenidoTextoRaiz));
		Correo mensajeHijo1 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		MensajeAbstracto mensajeHijo3 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		Correo correoHijo3 = new Adjunto(mensajeHijo3, archivo);

		raiz.añadir(mensajeRaiz);
		hijo1.añadir(mensajeHijo1);
		hijo3.añadir(correoHijo3);
		hijo1.añadir(hijo3);
		raiz.añadir(hijo1);
		raiz.añadir(hijo2);

		assertEquals(true, raiz.explorar().contains(mensajeRaiz));
		assertEquals(true, raiz.explorar().contains(hijo1));
		assertEquals(true, raiz.explorar().contains(hijo2));
	}

	/**
	 * <ul>
	 * <li>Nivel da prueba: Integracion</li>
	 * <li>Categorías a las que pertenece: Funcionales dinámicas de caja negra,
	 * positivas</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * @param nombreCarpetaRaiz   Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo1  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo2  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreCarpetaHijo3  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoRaiz     Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoRaiz  Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo1    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo1 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreTextoHijo3    Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoTextoHijo3 Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param nombreAudio         Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * @param contenidoAudio      Categoria: String cualquiera. Representantes:
	 *                            Generados automaticamente.
	 * 
	 * @throws OperacionInvalida
	 */
	@Property
	public void testIntegracionObtenerNoLeidos(String nombreCarpetaRaiz, String nombreCarpetaHijo1,
			String nombreCarpetaHijo2, String nombreCarpetaHijo3, String nombreTextoRaiz, String contenidoTextoRaiz,
			String nombreTextoHijo1, String contenidoTextoHijo1, String nombreTextoHijo3, String contenidoTextoHijo3,
			String nombreAudio, String contenidoAudio) throws OperacionInvalida {

		Carpeta raiz = new Carpeta(nombreCarpetaRaiz);
		Carpeta hijo1 = new Carpeta(nombreCarpetaHijo1);
		Carpeta hijo2 = new Carpeta(nombreCarpetaHijo2);
		Carpeta hijo3 = new Carpeta(nombreCarpetaHijo3);
		Archivo archivo = new Audio(nombreAudio, contenidoAudio);
		Correo mensajeRaiz = new Mensaje(new Texto(nombreTextoRaiz, contenidoTextoRaiz));
		Correo mensajeHijo1 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		MensajeAbstracto mensajeHijo3 = new Mensaje(new Texto(nombreTextoHijo1, contenidoTextoHijo1));
		Correo correoHijo3 = new Adjunto(mensajeHijo3, archivo);

		raiz.añadir(mensajeRaiz);
		hijo1.añadir(mensajeHijo1);
		hijo3.añadir(correoHijo3);
		hijo1.añadir(hijo3);
		raiz.añadir(hijo1);
		raiz.añadir(hijo2);

		correoHijo3.establecerLeido(true);

		assertEquals(2, raiz.obtenerNoLeidos());
	}
}
