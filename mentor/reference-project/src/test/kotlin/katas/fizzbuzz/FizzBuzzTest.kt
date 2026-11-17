package katas.fizzbuzz

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class FizzBuzzTest {

    @Test
    fun `returns the number itself when not divisible by 3 or 5`() {
        assertEquals("1", fizzBuzz(1))
    }

    @ParameterizedTest(name = "fizzBuzz({0}) = {1}")
    @CsvSource(
        "1, 1",
        "2, 2",
        "3, Fizz",
        "5, Buzz",
        "6, Fizz",
        "10, Buzz",
        "15, FizzBuzz",
        "30, FizzBuzz",
        "98, 98",
    )
    fun `maps numbers to their FizzBuzz word`(input: Int, expected: String) {
        assertEquals(expected, fizzBuzz(input))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -15])
    fun `rejects numbers below 1`(input: Int) {
        assertThrows<IllegalArgumentException> { fizzBuzz(input) }
    }

    @Test
    fun `sequence contains one entry per number`() {
        assertEquals(
            listOf("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"),
            fizzBuzzSequence(15),
        )
    }

    @Test
    fun `sequence up to 0 is empty`() {
        assertEquals(emptyList<String>(), fizzBuzzSequence(0))
    }
}
