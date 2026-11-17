# 1.3 JUnit & Test-First: FizzBuzz (1–2 days)

You know FizzBuzz. This time you write the **tests first**. The goal is not FizzBuzz —
it's learning the rhythm you will use for every exercise from now on:

> **Red** → write one test, run it, see it fail.
> **Green** → write the *simplest* code that makes it pass.
> **Refactor** → clean up the code while all tests stay green.
> Commit. Repeat.

## Specification

In package `katas.fizzbuzz`:

- `fun fizzBuzz(n: Int): String`
  - returns `"Fizz"` if `n` is divisible by 3
  - returns `"Buzz"` if `n` is divisible by 5
  - returns `"FizzBuzz"` if `n` is divisible by 3 **and** 5
  - otherwise returns the number as text, e.g. `"7"`
  - throws `IllegalArgumentException` if `n` is less than 1
- `fun fizzBuzzSequence(upTo: Int): List<String>`
  - returns the FizzBuzz values for `1..upTo`
  - `fizzBuzzSequence(0)` returns an empty list

## Tasks

Branch: `fizzbuzz`.

1. Write the **first** test only: `fizzBuzz(1)` returns `"1"`. Run it. It does not compile —
   that counts as red. Create the function so it compiles, run again, see it fail
   for the right reason, then make it pass.
2. Continue one rule at a time. **Commit after each green step.** Your MR should show
   the steps as separate commits.
3. When you have several similar tests, replace them with **one** `@ParameterizedTest`
   using `@CsvSource`.
4. Test the exception with `assertThrows<IllegalArgumentException> { ... }`.
5. Use the **debugger** once: put a breakpoint inside `fizzBuzz`, debug the test for 15
   and step through it.

## JUnit features to use

| Feature | Import |
|---|---|
| `@Test` | `org.junit.jupiter.api.Test` |
| `assertEquals(expected, actual)` | `org.junit.jupiter.api.Assertions.assertEquals` |
| `assertThrows<T> { }` | `org.junit.jupiter.api.assertThrows` (the Kotlin version) |
| `@ParameterizedTest` + `@CsvSource` | `org.junit.jupiter.params...` |

**Tip:** in Kotlin, test names can be sentences in backticks:
```kotlin
@Test
fun `returns Fizz for multiples of 3`() { ... }
```

## Done when

- [ ] All rules of the specification are covered by tests
- [ ] `mvn test` is green
- [ ] The MR has at least 5 commits, each one green
- [ ] There is at least one `@ParameterizedTest` and one `assertThrows`

## Questions to answer in the MR description

1. Why do we watch the test fail before writing the code?
2. Why is `assertEquals(expected, actual)` order important? (Make a test fail on purpose and
   read the message.)
3. In which order did you check 3, 5 and 15 in your code, and why does the order matter?
