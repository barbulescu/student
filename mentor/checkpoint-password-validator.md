# Block 2 Checkpoint: Password Validator

> **Mentor only.** Hand this out on the checkpoint day (around early January).
> She works alone for one office day. Reference solution and tests are in
> `kata-solutions/src/.../password/`.

---

## Kata: Password Validator

Write `fun validate(password: String): ValidationResult` in package `katas.password`.

```kotlin
data class ValidationResult(val errors: List<String>) {
    val isValid: Boolean get() = errors.isEmpty()
}
```

A password is valid if it:

1. is at least 8 characters long → otherwise error `must be at least 8 characters`
2. contains a digit → `must contain a digit`
3. contains an uppercase letter → `must contain an uppercase letter`
4. contains a lowercase letter → `must contain a lowercase letter`
5. contains one of `!@#$%^&*` → `must contain one of !@#$%^&*`

`validate` returns **all** broken rules, not only the first one, in the order above.

**Tasks:** write the tests first, implement, open an MR with a green pipeline, fill in the
MR template. You have until the end of the day.

---

## What to look for

| Ready ✅ | Not yet ❌ |
|---|---|
| Tests written before the implementation (check commit order) | All tests added in one commit at the end |
| One test per rule, plus "all errors reported" | Only the happy path tested |
| Clear test names | `test1`, `test2` |
| Rules not duplicated, e.g. a list of rule/message pairs or one small function per rule | Long `if` chain copied 5 times |
| Green pipeline, filled MR template | Asked for review with red pipeline |
| Finished in ≤ 1 day, asked questions when stuck | Silent for hours, then stuck |

If it's mostly ✅, Block 2 is done. If not, give her 1–2 more katas (e.g. *Mars Rover*,
*Tennis Score*, *Gilded Rose*) before starting Block 3.
