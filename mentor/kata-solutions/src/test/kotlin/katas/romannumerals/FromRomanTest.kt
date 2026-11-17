package katas.romannumerals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class FromRomanTest {

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("I, 1", "III, 3", "VIII, 8", "MD, 1500")
    fun `adds symbols`(roman: String, expected: Int) {
        assertEquals(expected, fromRoman(roman))
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource("IV, 4", "XC, 90", "MCMXCIV, 1994", "MMMCMXCIX, 3999")
    fun `subtracts a smaller symbol before a bigger one`(roman: String, expected: Int) {
        assertEquals(expected, fromRoman(roman))
    }

    @ParameterizedTest(name = "\"{0}\" is rejected")
    @ValueSource(strings = ["", "iv", "ABC", "IIII", "IC", "VV"])
    fun `rejects invalid numerals`(roman: String) {
        assertThrows<IllegalArgumentException> { fromRoman(roman) }
    }

    @Test
    fun `round trip works for every supported number`() {
        for (n in 1..3999) {
            assertEquals(n, fromRoman(toRoman(n)), "round trip failed for $n")
        }
    }
}
