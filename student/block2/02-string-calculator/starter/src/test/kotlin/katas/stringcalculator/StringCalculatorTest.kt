package katas.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Each @Nested class is one step. Finish a step (all green, commit!) before starting the next.
// In IntelliJ you can run a single nested class with the green arrow next to it.
class StringCalculatorTest {

    @Nested
    inner class `Step 1 - zero, one or two numbers` {

        @Test
        fun `empty string returns 0`() {
            assertEquals(0, add(""))
        }

        @Test
        fun `single number returns that number`() {
            assertEquals(7, add("7"))
        }

        @Test
        fun `two numbers separated by comma are added`() {
            assertEquals(3, add("1,2"))
        }
    }

    @Nested
    inner class `Step 2 - any amount of numbers` {

        @Test
        fun `five numbers are added`() {
            assertEquals(15, add("1,2,3,4,5"))
        }

        @Test
        fun `multi-digit numbers are added`() {
            assertEquals(1110, add("10,100,1000"))
        }
    }

    @Nested
    inner class `Step 3 - newlines as separators` {

        @Test
        fun `newline works like a comma`() {
            assertEquals(6, add("1\n2,3"))
        }

        @Test
        fun `only newlines`() {
            assertEquals(6, add("1\n2\n3"))
        }
    }

    @Nested
    inner class `Step 4 - custom delimiter` {

        @Test
        fun `first line can define a delimiter`() {
            assertEquals(3, add("//;\n1;2"))
        }

        @Test
        fun `custom delimiter can be any single character`() {
            assertEquals(10, add("//*\n1*2*3*4"))
        }
    }

    @Nested
    inner class `Step 5 - negative numbers` {

        @Test
        fun `a negative number is rejected`() {
            val exception = assertThrows<IllegalArgumentException> { add("1,-2,3") }
            assertEquals("negatives not allowed: -2", exception.message)
        }

        @Test
        fun `all negative numbers are listed in the message`() {
            val exception = assertThrows<IllegalArgumentException> { add("-1,2,-3") }
            assertEquals("negatives not allowed: -1, -3", exception.message)
        }
    }

    @Nested
    inner class `Step 6 - big numbers are ignored` {

        @Test
        fun `numbers bigger than 1000 are ignored`() {
            assertEquals(2, add("2,1001"))
        }

        @Test
        fun `1000 itself still counts`() {
            assertEquals(1002, add("2,1000"))
        }
    }
}
