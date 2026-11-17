# Kata 3: Roman Numerals

## Part 1: Number → Roman (tests given)

Write `fun toRoman(number: Int): String` in package `katas.romannumerals`.

| Symbol | I | V | X | L | C | D | M |
|---|---|---|---|---|---|---|---|
| Value | 1 | 5 | 10 | 50 | 100 | 500 | 1000 |

- Symbols are written from largest to smallest and added: `VIII` = 8
- A smaller symbol **before** a larger one is subtracted: `IV` = 4, `XC` = 90, `CM` = 900
- Only numbers from 1 to 3999 are supported, others → `IllegalArgumentException`

Copy `starter/src` into your project and make the tests green, top to bottom.

**Warning:** if your solution has a separate `if` for every number, stop. Look at
the examples and find the pattern. Hint: a **table** of values and symbols plus a
loop solves the whole kata.

## Part 2: Roman → Number (you write the tests)

Write `fun fromRoman(roman: String): Int`.

1. **Before any code**, write a test class `FromRomanTest` and commit it with only tests.
   The pipeline will be red. That's expected.
2. Think about:
   - simple cases (`"III"`)
   - subtraction cases (`"IV"`, `"MCMXCIV"`)
   - invalid input: empty string, lowercase, unknown letters like `"ABC"`
3. Then implement until green.
4. Bonus test: for **every** number from 1 to 3999, `fromRoman(toRoman(n)) == n`.
   How do you write that as a test?

Expected time: 1 office day.

## Questions to answer in the MR description

1. Which invalid inputs did you decide to reject, and what does your function do with them?
2. What does the round-trip test prove that the other tests don't?
