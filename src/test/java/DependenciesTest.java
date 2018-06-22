import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class DependenciesTest {

	private final JavaClasses javaClasses;

	public DependenciesTest() {
		this.javaClasses = new ClassFileImporter()
				.withImportOption(ImportOption.Predefined.DONT_INCLUDE_TESTS)
				.importClasspath();
	}

	@Test
	public void shouldHaveDependenciesOnlyToLowerPackages() {
		noClasses()
				.that()
				.resideInAPackage("package1")
				.should()
				.accessClassesThat()
				.resideOutsideOfPackages(
						"java..",
						"..package1..",
						"..package2..")
				.check(this.javaClasses);
	}
}
