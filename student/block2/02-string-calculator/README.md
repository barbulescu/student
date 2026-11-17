# Kata 2: String Calculator

Write `fun add(numbers: String): Int` in package `katas.stringcalculator`.
It takes numbers inside a string and returns their sum.

## Setup

Copy `starter/src` into your `katas` project. The test class has **6 nested classes,
one per step**. Run one step at a time in IntelliJ (green arrow next to the nested class).

## Steps

1. **Zero, one or two numbers**: `""` → 0, `"7"` → 7, `"1,2"` → 3
2. **Any amount of numbers**: `"1,2,3,4,5"` → 15
3. **Newlines as separators**: `"1\n2,3"` → 6
4. **Custom delimiter**: the first line may be `//<delimiter>`, e.g. `"//;\n1;2"` → 3
5. **Negatives**: throw `IllegalArgumentException` with the message
   `negatives not allowed: -1, -3`, listing **all** negative numbers
6. **Big numbers**: numbers bigger than 1000 are ignored: `"2,1001"` → 2

## Important

- **Only** look at the next step after the current one is green and committed.
  Solve the step in front of you, not the ones after it.
- After step 4 your `add` function is probably getting long. **Refactor**: extract
  small private functions with good names (e.g. for "find the delimiter" or "parse the
  numbers"). All tests must stay green while you refactor.

## Kotlin hints

- `split(",", "\n")` accepts several delimiters.
- `startsWith`, `substringBefore`, `substringAfter`, `removePrefix` are useful for step 4.
- `filter`, `map`, `sum`, `joinToString(", ")` are useful for steps 5 and 6.

Expected time: ½–1 office day.

## Questions to answer in the MR description

1. Which step forced you to change your code the most? Why?
2. Show one refactoring you did and explain why the code is better now.
