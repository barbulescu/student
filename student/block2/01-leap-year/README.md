# Kata 1: Leap Year

Write `fun isLeapYear(year: Int): Boolean` in package `katas.leapyear`.

## Rules (Gregorian calendar)

- A year divisible by 4 is a leap year,
- **except** years divisible by 100, which are not,
- **except** years divisible by 400, which are.
- Years below 1 are invalid → `IllegalArgumentException`.

Examples: 2024 ✅ · 2023 ❌ · 1900 ❌ · 2000 ✅

## Setup

Copy `starter/src` into your `katas` project. Run `LeapYearTest` — everything is red.

## Steps

The tests are ordered from simple to complex. Make them pass **top to bottom**.
After each green step: commit.

When all tests are green, look at your code again:
- Can you write the logic as **one** boolean expression?
- Is that more or less readable than `if`/`when`? Pick one and explain why in the MR.

## Kotlin hints

- `require(condition) { "message" }` throws `IllegalArgumentException` if the condition is false.
- `%` is the remainder operator: `2024 % 4 == 0`.

Expected time: 1–2 hours.
