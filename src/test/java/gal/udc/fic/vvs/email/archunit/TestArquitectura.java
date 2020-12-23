package gal.udc.fic.vvs.email.archunit;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

/**
 * @author r.sanchezarias6@gmail.com
 *
 */
public class TestArquitectura {

	/**
	 * /**
	 * <ul>
	 * <li>Nivel da prueba: Unitaria</li>
	 * <li>Categorías a las que pertenece: Dinámicas estructurales de caja blanca</li>
	 * </ul>
	 * <p>
	 * *
	 * 
	 * Probamos que todas las clases del paquete Archivador tienen que ser publicas.
	 * 
	 */
	@Test
	public void ClasesEnPaqueteArchivadorDebenSerPublicas() {

		JavaClasses importedClasses = new ClassFileImporter().importPackages("gal.udc.fic.vvs.email");

		ArchRule rule = classes()
				.that().resideInAPackage("..archivador..")
				.should().bePublic().because("son clases que debe instanciar el cliente");

		rule.check(importedClasses);
	}
}
