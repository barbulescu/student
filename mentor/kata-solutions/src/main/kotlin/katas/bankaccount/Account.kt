package katas.bankaccount

import java.time.LocalDate

data class StatementLine(val date: LocalDate, val amountInCents: Long, val balanceInCents: Long)

class InsufficientFundsException(requested: Long, available: Long) :
    RuntimeException("cannot withdraw $requested cents, balance is $available cents")

class Account(private val today: () -> LocalDate = { LocalDate.now() }) {

    private val transactions = mutableListOf<StatementLine>()

    var balanceInCents: Long = 0
        private set

    fun deposit(amountInCents: Long) {
        requirePositive(amountInCents)
        record(amountInCents)
    }

    fun withdraw(amountInCents: Long) {
        requirePositive(amountInCents)
        if (amountInCents > balanceInCents) throw InsufficientFundsException(amountInCents, balanceInCents)
        record(-amountInCents)
    }

    /** Newest transaction first. */
    fun statement(): List<StatementLine> = transactions.reversed()

    private fun record(signedAmount: Long) {
        balanceInCents += signedAmount
        transactions += StatementLine(today(), signedAmount, balanceInCents)
    }

    private fun requirePositive(amountInCents: Long) {
        require(amountInCents > 0) { "amount must be positive, was $amountInCents" }
    }
}
