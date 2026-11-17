package katas.password

const val SPECIAL_CHARACTERS = "!@#$%^&*"

data class ValidationResult(val errors: List<String>) {
    val isValid: Boolean get() = errors.isEmpty()
}

private val RULES: List<Pair<(String) -> Boolean, String>> = listOf(
    { p: String -> p.length >= 8 } to "must be at least 8 characters",
    { p: String -> p.any { it.isDigit() } } to "must contain a digit",
    { p: String -> p.any { it.isUpperCase() } } to "must contain an uppercase letter",
    { p: String -> p.any { it.isLowerCase() } } to "must contain a lowercase letter",
    { p: String -> p.any { it in SPECIAL_CHARACTERS } } to "must contain one of $SPECIAL_CHARACTERS",
)

fun validate(password: String): ValidationResult =
    ValidationResult(RULES.filterNot { (check, _) -> check(password) }.map { (_, message) -> message })
