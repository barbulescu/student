package katas.fizzbuzz

fun fizzBuzz(n: Int): String {
    require(n >= 1) { "n must be at least 1, was $n" }
    return when {
        n % 15 == 0 -> "FizzBuzz"
        n % 3 == 0 -> "Fizz"
        n % 5 == 0 -> "Buzz"
        else -> n.toString()
    }
}

fun fizzBuzzSequence(upTo: Int): List<String> = (1..upTo).map(::fizzBuzz)
