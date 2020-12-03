package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAudio {

	@Test
	public void testObetenerNombre() {

		String nombreAudio = "Nombre Audio";
		String contenido = "Contenido Audio";
		Audio audio = new Audio(nombreAudio, contenido);

		assertEquals(nombreAudio, audio.obtenerNombre());
	}

	@Test
	public void testObtenerContenido() {

		String nombreAudio = "Nombre Audio";
		String contenidoAudio = "Contenido Audio";
		Audio audio = new Audio(nombreAudio, contenidoAudio);

		assertEquals(contenidoAudio, audio.obtenerContenido());
	}

	@Test
	public void testObtenerTamaño() {

		String nombreAudio = "Nombre Audio";
		String contenido = "Contenido Audio";
		Audio audio = new Audio(nombreAudio, contenido);

		assertEquals(contenido.length(), audio.obtenerTamaño());
	}

	@Test
	public void testObtenerPreVisualizacion() {

		String nombreAudio = "Nombre Audio";
		String contenido = "Contenido Audio";
		Audio audio = new Audio(nombreAudio, contenido);

		assertEquals(nombreAudio + "(" + audio.obtenerTamaño() + " bytes, " + audio.obtenerMimeType() + ")",
				audio.obtenerPreVisualizacion());
	}
}
