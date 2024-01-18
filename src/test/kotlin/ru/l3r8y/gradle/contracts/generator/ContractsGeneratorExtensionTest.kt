package ru.l3r8y.gradle.contracts.generator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ContractsGeneratorExtensionTest {

    @Test
    fun `just empty test`() {
        assertDoesNotThrow {
            ContractsGeneratorExtension()
        }
    }
}