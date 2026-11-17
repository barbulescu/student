package katas.stringcalculator

private const val CUSTOM_DELIMITER_PREFIX = "//"
private const val MAX_NUMBER = 1000

fun add(numbers: String): Int {
    if (numbers.isEmpty()) return 0

    val (delimiters, body) = parseDelimiters(numbers)
    val values = body.split(*delimiters).map { it.toInt() }

    val negatives = values.filter { it < 0 }
    require(negatives.isEmpty()) { "negatives not allowed: ${negatives.joinToString(", ")}" }

    return values.filter { it <= MAX_NUMBER }.sum()
}

private fun parseDelimiters(input: String): Pair<Array<String>, String> {
    if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) return arrayOf(",", "\n") to input

    val header = input.substringBefore("\n")
    val custom = header.removePrefix(CUSTOM_DELIMITER_PREFIX)
    return arrayOf(custom, "\n") to input.substringAfter("\n")
}
