package gal.udc.fic.vvs.email;

import gal.udc.fic.vvs.email.archivador.ArchivadorSimple;
import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.cliente.Cliente;
import gal.udc.fic.vvs.email.cliente.ClienteImp;
import gal.udc.fic.vvs.email.correo.Adjunto;
import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;
import gal.udc.fic.vvs.email.correo.Reenvio;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		//System.out.println("Hello World!");

		try {
			Carpeta global = new Carpeta("O meu correo");
			Carpeta personal = new Carpeta("Persoal");
			Carpeta personalAmigos = new Carpeta("Amizades");
			Carpeta personalFamilia = new Carpeta("Familia");
			Carpeta trabajo = new Carpeta("Traballo");
			CarpetaLimitada personalLimitada = new CarpetaLimitada(personal, 5000);

			Correo correo = new Mensaje(new Texto("Duda VVS", "Hola tengo una duda de vvs"));

			Carpeta trabajoVVS = new Carpeta("VVS");
			trabajoVVS.añadir(correo);

			Texto texto = new Texto("Descarga", "Aqui tienes la cancion que has descargadp");
			MensajeAbstracto mensaje = new Mensaje(texto);
			Archivo archivo = new Audio("Audio Nuevo", "Cancion");

			Correo correo2 = new Adjunto(mensaje, archivo);

			trabajoVVS.añadir(correo2);

			Carpeta trabajoDepartamento = new Carpeta("Departamento");
			Carpeta trabajoGeneral = new Carpeta("Xeral");
			Carpeta listas = new Carpeta("Listas");
			Carpeta listasPF = new Carpeta("Programación Funcional");
			Carpeta listasVA = new Carpeta("Validación Automática");

			global.añadir(listas);
			global.añadir(trabajo);
			global.añadir(new CarpetaLimitada(personal, 3));

			global.añadir(personalLimitada);

			listas.añadir(listasPF);
			listas.añadir(listasVA);

			trabajo.añadir(trabajoVVS);
			trabajo.añadir(trabajoDepartamento);
			trabajo.añadir(trabajoGeneral);

			personal.añadir(personalAmigos);
			personal.añadir(personalFamilia);
			personal.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico.")));

			personalFamilia.añadir(new Reenvio(
					new Cabecera(
							new Cabecera(new Mensaje(new Texto("contido", "Contido do correo electrónico persoal 1.")),
									"Para", "lcastro@udc.es"),
							"De", "vvs@fic.udc.es"),
					new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1."))));
			personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 1.")));
			personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 2.")));
			personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 3.")));
			personalFamilia.añadir(new Mensaje(new Texto("contido", "Contido do correo electrónico familiar 4.")));

			Cliente cliente = new ClienteImp(global);

			ArchivadorSimple gmail = new ArchivadorSimple("GMail", 100);
			ArchivadorSimple outlook = new ArchivadorSimple("Outlook", 100);
			cliente.agregarArchivador(outlook);
			cliente.agregarArchivador(gmail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
