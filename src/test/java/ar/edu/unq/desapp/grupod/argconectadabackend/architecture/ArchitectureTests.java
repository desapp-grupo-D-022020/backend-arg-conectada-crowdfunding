package ar.edu.unq.desapp.grupod.argconectadabackend.architecture;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;


public class ArchitectureTests {
	
    @Test
    public void serviceOnlyAccessedByWebservices() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupod.argconectadabackend");

        ArchRule rule = classes()
                .that().resideInAPackage("..service..")
                .should().onlyBeAccessed().byAnyPackage("..webservices..", "..service..", "..JWT..", "..job..");

        rule.check(importedClasses);
    }

    @Test
    public void modelOnlyAccessedByServiceandSecurity(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupod.argconectadabackend");

        ArchRule rule = classes()
                .that().resideInAPackage("..model..")
                .should().onlyBeAccessed().byAnyPackage("..service..", "..webservices..", "..model..", "..security..", "..validations..");

        rule.check(importedClasses);
    }

    @Test
    public void repositoryOnlyAccessedByService(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupod.argconectadabackend");

        ArchRule rule = classes()
                .that().resideInAPackage("..repository..")
                .should().onlyBeAccessed().byAnyPackage("..service..", "..repository..");

        rule.check(importedClasses);
    }

    @Test
    public void webservicesOnlyAccessedBySelf(){
        JavaClasses importedClasses = new ClassFileImporter().importPackages("ar.edu.unq.desapp.grupod.argconectadabackend");

        ArchRule rule = classes()
                .that().resideInAPackage("..webservices..")
                .should().onlyBeAccessed().byAnyPackage("..webservices..");

        rule.check(importedClasses);
    }
}
