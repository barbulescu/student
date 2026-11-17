# Block 2: Problem Solving Test-First (3–4 weeks)

A **kata** is a small exercise you practise until the technique becomes automatic.
The katas get harder step by step, and you get less help each time:

| # | Kata | Tests | New concept |
|---|---|---|---|
| 1 | [Leap Year](01-leap-year/README.md) | given | Conditions, boolean logic |
| 2 | [String Calculator](02-string-calculator/README.md) | given | Parsing strings, exceptions, small helper functions |
| 3 | [Roman Numerals](03-roman-numerals/README.md) | given + you write part 2 | Loops, lookup tables, refactoring |
| 4 | [Word Frequency](04-word-frequency/README.md) | **you write them** | Collections: `Map`, `groupBy`, sorting |
| 5 | [Bank Account](05-bank-account/README.md) | **you write them** | Classes, state, custom exceptions, data classes |

## Workflow for every kata

1. Create a branch from an up-to-date `main`, e.g. `kata/leap-year`.
2. If the kata has a `starter/` folder: copy its `src/` content into your `katas` project.
   The tests compile but fail — that's your red starting point.
3. Make the tests pass **one at a time**, top to bottom. Commit after each green step.
4. Refactor: is the code readable? Would a colleague understand it without explanation?
5. Push, check the pipeline, open the MR, fill in the template.

## Rules

- **Do not change the given tests.** If you think a test is wrong, ask in the MR.
- Solve it yourself, without AI tools or copied solutions. These katas are
  well known and solutions are everywhere online, so looking one up skips the exercise.
  Use the Kotlin documentation as much as you want.
- Timebox: if a kata takes longer than **one office day**, stop, push what you have, and
  ask for help in the MR.

## Block 2 is done when

You can take a **kata you have never seen**, write the tests yourself from a text
description, and solve it in one office day. Your mentor will give you one to check.
