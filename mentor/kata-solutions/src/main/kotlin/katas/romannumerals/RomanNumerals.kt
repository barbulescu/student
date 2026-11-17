package katas.romannumerals

private val SYMBOLS = listOf(
    1000 to "M", 900 to "CM", 500 to "D", 400 to "CD",
    100 to "C", 90 to "XC", 50 to "L", 40 to "XL",
    10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I",
)

fun toRoman(number: Int): String {
    require(number in 1..3999) { "only 1..3999 supported, was $number" }

    var rest = number
    return buildString {
        for ((value, symbol) in SYMBOLS) {
            while (rest >= value) {
                append(symbol)
                rest -= value
            }
        }
    }
}

private val SYMBOL_VALUES = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

fun fromRoman(roman: String): Int {
    require(roman.isNotEmpty() && roman.all { it in SYMBOL_VALUES }) { "not a roman numeral: '$roman'" }

    val values = roman.map { SYMBOL_VALUES.getValue(it) }
    val number = values.indices.sumOf { i ->
        val next = values.getOrNull(i + 1) ?: 0
        if (values[i] < next) -values[i] else values[i]
    }
    // Rejects non-canonical forms like "IIII" or "IC"
    require(number in 1..3999 && toRoman(number) == roman) { "not a valid roman numeral: '$roman'" }
    return number
}
