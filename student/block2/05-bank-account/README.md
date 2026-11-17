# Kata 5: Bank Account — you write the tests

This kata connects to block 3: instead of a single function you design a **class with state**.

## Specification

In package `katas.bankaccount`:

```kotlin
class Account(today: () -> LocalDate = { LocalDate.now() }) {
    val balanceInCents: Long          // readable from outside, NOT settable from outside
    fun deposit(amountInCents: Long)
    fun withdraw(amountInCents: Long)
    fun statement(): List<StatementLine>
}

data class StatementLine(val date: LocalDate, val amountInCents: Long, val balanceInCents: Long)
```

Rules:

- A new account has balance 0 and an empty statement.
- `deposit` increases the balance; `withdraw` decreases it.
- Amounts must be **positive** → otherwise `IllegalArgumentException`.
- You cannot withdraw more than the balance → throw your own `InsufficientFundsException`.
  A failed withdrawal must **not** change the balance.
- `statement()` returns one line per transaction, **newest first**:
  - `date` = the day of the transaction
  - `amountInCents` = positive for deposits, negative for withdrawals
  - `balanceInCents` = the balance **after** this transaction

## Why amounts in cents?

`0.1 + 0.2` is not `0.3` with `Double`. Never use `Double` for money. We use `Long`
cents here; in real projects you'll often see `BigDecimal`.

## Why `today: () -> LocalDate`?

If the account calls `LocalDate.now()` directly, your tests can't predict the dates
in the statement. Passing in "where the date comes from" lets the test control it:

```kotlin
private var today = LocalDate.of(2026, 12, 10)
private val account = Account { today }

// later in a test: today = LocalDate.of(2026, 12, 14)
```

This idea is called **dependency injection**, and Spring Boot is built on it.

## Tasks

1. Write the tests for the rules above, one rule at a time, test-first.
2. Use a `@ParameterizedTest` for the "amount must be positive" rules.
3. Make sure `balanceInCents` can't be changed from outside (`private set`).
4. Open the MR.

**Bonus:** add `fun printStatement(): String` that returns a formatted table:
```
Date       |  Amount | Balance
2026-12-14 |  -50.00 |  450.00
2026-12-10 |  500.00 |  500.00
```

Expected time: 1–2 office days.

## Questions to answer in the MR description

1. Why is `StatementLine` a `data class`? What would break in your tests if it wasn't?
2. Why does `InsufficientFundsException` exist instead of reusing `IllegalArgumentException`?
