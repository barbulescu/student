# Kata 4: Word Frequency — you write the tests

No starter this time. You turn a text specification into tests yourself.

## Specification

In package `katas.wordfrequency`:

### `fun wordFrequency(text: String): Map<String, Int>`
Counts how often each word appears in `text`.

- A word consists of letters and/or digits. `"Route 66"` has the words `route` and `66`.
- Counting is **case-insensitive**; the keys in the map are **lowercase**.
- Punctuation is not part of a word: `"Hi, there! Hi?"` → `hi=2, there=1`.
- An apostrophe **inside** a word belongs to it: `"don't"` is one word.
  Quotes **around** a word don't: `"'quoted'"` → `quoted`.
- Empty or blank text → empty map.

### `fun topWords(text: String, n: Int): List<Pair<String, Int>>`
Returns the `n` most frequent words with their counts.

- Sorted by count, **highest first**.
- Words with the same count are sorted **alphabetically**.
- If `n` is bigger than the number of distinct words, return all of them.
- `n = 0` → empty list; negative `n` → `IllegalArgumentException`.

## Tasks

1. Read the specification and write **one test per rule**. Use good test names that
   say the rule, e.g. `` `ignores punctuation` ``. Use `@Nested` to group the tests for
   the two functions.
2. Commit the tests on their own (red pipeline is OK on this branch).
3. Implement `wordFrequency`, then `topWords`.
4. Open the MR. In the description, list which rule each test covers.

## Kotlin hints

- `lowercase()`, `Regex`, `findAll`
- `groupingBy { it }.eachCount()` or `groupBy` + `mapValues`
- `sortedWith(compareByDescending<...> { ... }.thenBy { ... })`, `take(n)`, `toList()`

Expected time: 1 office day.

## Questions to answer in the MR description

1. Did you find a rule in the specification that was unclear? How did you decide?
2. Which test was the hardest to write, and why?
