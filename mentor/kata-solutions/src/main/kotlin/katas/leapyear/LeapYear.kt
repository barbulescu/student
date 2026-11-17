package katas.leapyear

fun isLeapYear(year: Int): Boolean {
    require(year >= 1) { "year must be at least 1, was $year" }
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
}
