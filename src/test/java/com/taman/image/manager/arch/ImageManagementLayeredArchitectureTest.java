package com.taman.image.manager.arch;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.taman.image.manager.util.TestHelper.BASE_PACKAGE;
import static com.tngtech.archunit.lang.conditions.ArchConditions.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = BASE_PACKAGE
        , importOptions = DoNotIncludeTests.class)
public interface ImageManagementLayeredArchitectureTest {

    // All layers architecture test rules
    @ArchTest
    ArchRule layer_dependencies_are_respected = layeredArchitecture().consideringAllDependencies()
            .layer("apis").definedBy(BASE_PACKAGE.concat(".api.."))
            .layer("controllers").definedBy(BASE_PACKAGE.concat(".api.controller"))
            .layer("services").definedBy(BASE_PACKAGE.concat(".service"))
            .layer("servicesImpl").definedBy(BASE_PACKAGE.concat(".service.impl"))
            .layer("repositories").definedBy(BASE_PACKAGE.concat(".repository"))
            .layer("domain").definedBy(BASE_PACKAGE.concat(".domain"))
            .layer("infra").definedBy(BASE_PACKAGE.concat(".infra"))

            .whereLayer("controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("services").mayOnlyBeAccessedByLayers("controllers", "servicesImpl")
            .whereLayer("repositories").mayOnlyBeAccessedByLayers("repositories", "servicesImpl")
            .whereLayer("domain").mayOnlyBeAccessedByLayers("repositories", "services");

    // Domain layer architecture test rules
    @ArchTest
    ArchRule classes_in_domain_layer_should_be_annotated_as_entities =
            classes().that().resideInAPackage("..domain..")
                    .should(beAnnotatedWith(Entity.class))
                    .as("""
                            Classes resides in domain layer,
                            should be annotated with '@Entity' annotation.""");

    @ArchTest
    ArchRule entities_must_reside_in_a_domain_layer =
            classes().that().areAnnotatedWith(Entity.class)
                    .should(resideInAPackage("..domain.."))
                    .as("Entities should reside in a package '..domain..'");

    // Controller layer architecture test rules
    @ArchTest
    ArchRule classes_in_controller_layer_should_be_annotated_as_restController =
            classes().that().resideInAPackage("..controller..")
                    .should(beAnnotatedWith(RestController.class))
                    .as("""
                            Classes resides in controller layer, should be annotated
                            with '@RestController' annotation.""");

    @ArchTest
    ArchRule classes_annotated_as_restController_should_reside_in_controller_layer =
            classes().that().areAnnotatedWith(RestController.class)
                    .should(resideInAPackage("..controller.."))
                    .as("""
                            Classes annotated with '@RestController',
                            "should reside in '..controller..' layer.""");

    @ArchTest
    ArchRule controllers_should_be_suffixed =
            classes()
                    .that().resideInAPackage("..controller..")
                    .or()
                    .areAnnotatedWith(RestController.class)
                    //.or().areAssignableTo(AbstractController.class)
                    .should().haveSimpleNameEndingWith("Controller")
                    .as("Controllers should reside in a package '..controller..'");


    // Service layer architecture test rules
    @ArchTest
    ArchRule classes_in_service_layer_should_be_annotated_as_service =
            classes().that().resideInAPackage("..service.impl..")
                    .should(beAnnotatedWith(Service.class))
                    .as("Services implementation should be annotated with '@Service' annotation.");

    @ArchTest
    ArchRule classes_with_names_ending_with_service_should_resides_in_services_layer =
            classes().that().haveNameMatching(".*Service")
                    .should(resideInAPackage("..service.."));


    // Repository layer architecture test rules
    @ArchTest
    ArchRule interfaces_in_repository_layer_should_be_interface_annotated_as_repository =
            classes().that().resideInAPackage("..repository..")
                    .should(beInterfaces())
                    .andShould(beAnnotatedWith(Repository.class));

    @ArchTest
    ArchRule interfaces_in_repository_layer_should_implement_crudRepository_interface =
            classes().that().areInterfaces()
                    .and().resideInAPackage("..repository..")
                    .should(beAssignableTo(CrudRepository.class))
                    .as("Repositories should be annotated with '@CrudRepository' annotation.");

    @ArchTest
    ArchRule interfaces_with_names_ending_with_repository_should_resides_in_repositories_layer =
            classes().that().areInterfaces()
                    .and().haveNameMatching(".*Repository")
                    .should(resideInAPackage("..repository.."));
}
