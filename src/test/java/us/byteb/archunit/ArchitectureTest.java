package us.byteb.archunit;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeJars;
import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(
    packages = "us.byteb.archunit",
    importOptions = {DoNotIncludeTests.class, DoNotIncludeJars.class})
public class ArchitectureTest {

  @ArchTest
  public static final ArchRule DEPENDENCY_TEST_EXAMPLE =
      classes()
          .that()
          .resideInAPackage("..app..")
          .should()
          .onlyDependOnClassesThat(resideInAPackage("..lib..").or(resideInAPackage("java.lang..")));
}
