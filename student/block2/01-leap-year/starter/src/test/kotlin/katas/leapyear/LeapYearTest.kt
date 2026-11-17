package katas.leapyear

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

// Make these tests pass one at a time, top to bottom.
class LeapYearTest {

    @ParameterizedTest(name = "{0} is not a leap year")
    @ValueSource(ints = [2023, 2001, 1999])
    fun `a year not divisible by 4 is not a leap year`(year: Int) {
        assertFalse(isLeapYear(year))
    }

    @ParameterizedTest(name = "{0} is a leap year")
    @ValueSource(ints = [2024, 1996, 4])
    fun `a year divisible by 4 is a leap year`(year: Int) {
        assertTrue(isLeapYear(year))
    }

    @ParameterizedTest(name = "{0} is not a leap year")
    @ValueSource(ints = [1900, 2100, 1800])
    fun `a year divisible by 100 is not a leap year`(year: Int) {
        assertFalse(isLeapYear(year))
    }

    @ParameterizedTest(name = "{0} is a leap year")
    @ValueSource(ints = [2000, 1600, 2400])
    fun `a year divisible by 400 is a leap year`(year: Int) {
        assertTrue(isLeapYear(year))
    }

    @ParameterizedTest(name = "{0} is rejected")
    @ValueSource(ints = [0, -1, -2024])
    fun `years before 1 are rejected`(year: Int) {
        assertThrows<IllegalArgumentException> { isLeapYear(year) }
    }
}
