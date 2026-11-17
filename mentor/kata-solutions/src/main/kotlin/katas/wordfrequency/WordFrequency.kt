package katas.wordfrequency

// Letters/digits, optionally joined by apostrophes: "don't", "rock'n'roll"
private val WORD = Regex("[\\p{L}\\p{N}]+(?:'[\\p{L}\\p{N}]+)*")

fun wordFrequency(text: String): Map<String, Int> =
    WORD.findAll(text.lowercase())
        .map { it.value }
        .groupingBy { it }
        .eachCount()

fun topWords(text: String, n: Int): List<Pair<String, Int>> {
    require(n >= 0) { "n must not be negative, was $n" }
    return wordFrequency(text).toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
        .take(n)
}
