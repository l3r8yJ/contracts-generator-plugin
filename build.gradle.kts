plugins {
    jacoco
    `kotlin-dsl`
    `maven-publish`
    kotlin("jvm") version libs.versions.kotlinJvm.get()
}

group = "ru.l3r8y"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation(gradleTestKit())
}

gradlePlugin {
    plugins {
        create("contracts-generator-plugin") {
            id = "ru.l3r8y.gradle.contracts.generator"
            implementationClass = "ru.l3r8y.gradle.contracts.generator.ContractsGeneratorPlugin"
            description = "Generates REST and GraphQL contracts with openapi generator"
            displayName = "Contracts Generator Plugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    enabled = true
    reports {
        xml.required = true
        html.required = true
    }
    dependsOn(tasks.test)
}

kotlin {
    jvmToolchain(21)
}