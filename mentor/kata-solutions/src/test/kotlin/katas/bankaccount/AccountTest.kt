package katas.bankaccount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate

class AccountTest {

    // The test controls "today" so the statement dates are predictable
    private var today: LocalDate = LocalDate.of(2026, 12, 10)
    private val account = Account { today }

    @Test
    fun `new account has zero balance and empty statement`() {
        assertEquals(0, account.balanceInCents)
        assertEquals(emptyList<StatementLine>(), account.statement())
    }

    @Test
    fun `deposit increases the balance`() {
        account.deposit(500_00)
        assertEquals(500_00, account.balanceInCents)
    }

    @Test
    fun `withdraw decreases the balance`() {
        account.deposit(500_00)
        account.withdraw(120_50)
        assertEquals(379_50, account.balanceInCents)
    }

    @Test
    fun `withdrawing the whole balance is allowed`() {
        account.deposit(100)
        account.withdraw(100)
        assertEquals(0, account.balanceInCents)
    }

    @Test
    fun `cannot withdraw more than the balance`() {
        account.deposit(100)
        assertThrows<InsufficientFundsException> { account.withdraw(101) }
        assertEquals(100, account.balanceInCents, "failed withdrawal must not change the balance")
    }

    @ParameterizedTest
    @ValueSource(longs = [0, -1, -500])
    fun `deposit rejects amounts that are not positive`(amount: Long) {
        assertThrows<IllegalArgumentException> { account.deposit(amount) }
    }

    @ParameterizedTest
    @ValueSource(longs = [0, -1, -500])
    fun `withdraw rejects amounts that are not positive`(amount: Long) {
        account.deposit(1000)
        assertThrows<IllegalArgumentException> { account.withdraw(amount) }
    }

    @Test
    fun `statement lists transactions newest first with running balance`() {
        account.deposit(500_00)
        today = LocalDate.of(2026, 12, 14)
        account.withdraw(50_00)

        assertEquals(
            listOf(
                StatementLine(LocalDate.of(2026, 12, 14), -50_00, 450_00),
                StatementLine(LocalDate.of(2026, 12, 10), 500_00, 500_00),
            ),
            account.statement(),
        )
    }
}
