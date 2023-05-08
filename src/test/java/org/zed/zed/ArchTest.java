package org.zed.zed;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.zed.zed");

        noClasses()
            .that()
            .resideInAnyPackage("org.zed.zed.service..")
            .or()
            .resideInAnyPackage("org.zed.zed.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.zed.zed.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
