package katas.romannumerals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RomanNumeralsTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("1, I", "5, V", "10, X", "50, L", "100, C", "500, D", "1000, M")
    fun `single symbols`(number: Int, expected: String) {
        assertEquals(expected, toRoman(number))
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("2, II", "3, III", "6, VI", "8, VIII", "20, XX", "30, XXX", "1500, MD")
    fun `symbols are added from left to right`(number: Int, expected: String) {
        assertEquals(expected, toRoman(number))
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("4, IV", "9, IX", "40, XL", "90, XC", "400, CD", "900, CM")
    fun `a smaller symbol before a bigger one is subtracted`(number: Int, expected: String) {
        assertEquals(expected, toRoman(number))
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("14, XIV", "49, XLIX", "99, XCIX", "1994, MCMXCIV", "2026, MMXXVI", "3999, MMMCMXCIX")
    fun `combined numbers`(number: Int, expected: String) {
        assertEquals(expected, toRoman(number))
    }

    @ParameterizedTest(name = "{0} is rejected")
    @ValueSource(ints = [0, -1, 4000])
    fun `only numbers from 1 to 3999 are supported`(number: Int) {
        assertThrows<IllegalArgumentException> { toRoman(number) }
    }
}
