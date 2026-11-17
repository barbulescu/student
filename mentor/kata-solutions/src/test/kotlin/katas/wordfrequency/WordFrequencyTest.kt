package katas.wordfrequency

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Example of what good student tests could look like: one test per rule in the task sheet.
class WordFrequencyTest {

    @Nested
    inner class WordFrequency {

        @Test
        fun `blank text has no words`() {
            assertEquals(emptyMap<String, Int>(), wordFrequency("   \n "))
        }

        @Test
        fun `counts repeated words`() {
            assertEquals(mapOf("the" to 2, "cat" to 1), wordFrequency("the cat the"))
        }

        @Test
        fun `is case-insensitive and returns lowercase words`() {
            assertEquals(mapOf("hello" to 3), wordFrequency("Hello HELLO hello"))
        }

        @Test
        fun `ignores punctuation`() {
            assertEquals(mapOf("hi" to 2, "there" to 1), wordFrequency("Hi, there! Hi?"))
        }

        @Test
        fun `keeps apostrophes inside words`() {
            assertEquals(mapOf("don't" to 1, "stop" to 1), wordFrequency("don't stop"))
        }

        @Test
        fun `strips quotes around words`() {
            assertEquals(mapOf("quoted" to 1), wordFrequency("'quoted'"))
        }

        @Test
        fun `counts numbers as words`() {
            assertEquals(mapOf("route" to 1, "66" to 1), wordFrequency("Route 66"))
        }
    }

    @Nested
    inner class TopWords {

        @Test
        fun `sorts by count, most frequent first`() {
            assertEquals(listOf("b" to 3, "a" to 2), topWords("a b b a b c", 2))
        }

        @Test
        fun `breaks ties alphabetically`() {
            assertEquals(listOf("apple" to 1, "mango" to 1, "zebra" to 1), topWords("zebra apple mango", 3))
        }

        @Test
        fun `returns all words when n is bigger than the number of words`() {
            assertEquals(listOf("one" to 1), topWords("one", 10))
        }

        @Test
        fun `n of 0 returns nothing`() {
            assertEquals(emptyList<Pair<String, Int>>(), topWords("one two", 0))
        }

        @Test
        fun `rejects negative n`() {
            assertThrows<IllegalArgumentException> { topWords("one", -1) }
        }
    }
}
