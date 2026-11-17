package katas.password

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PasswordValidatorTest {

    @Test
    fun `a password matching all rules is valid`() {
        val result = validate("Secret1!")
        assertTrue(result.isValid)
        assertEquals(emptyList<String>(), result.errors)
    }

    @ParameterizedTest(name = "\"{0}\" -> {1}")
    @CsvSource(
        "Secr1!, must be at least 8 characters",
        "Secret!!, must contain a digit",
        "secret1!, must contain an uppercase letter",
        "SECRET1!, must contain a lowercase letter",
        "Secret12, must contain one of !@#$%^&*",
    )
    fun `each broken rule is reported`(password: String, expectedError: String) {
        val result = validate(password)
        assertFalse(result.isValid)
        assertEquals(listOf(expectedError), result.errors)
    }

    @Test
    fun `all broken rules are reported, not only the first`() {
        assertEquals(5, validate("").errors.size)
    }
}
