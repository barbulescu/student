# MR Review Checklist (5–15 min per MR)

Read in this order. Stop at the first level that fails and comment on that only. Too
many comments at once overwhelm a beginner.

## 1. Process (1 min)
- [ ] Pipeline green?
- [ ] MR template filled in, especially **"What was hard"**?
- [ ] Task-sheet questions answered?
- [ ] Several small commits, not one big one? Test commits before code commits?

## 2. Tests (3–5 min)
- [ ] Does every rule of the specification have a test?
- [ ] Do test names describe behaviour (`rejects negative amounts`) and not mechanics (`testWithdraw2`)?
- [ ] Edge cases: empty input, zero, boundaries (1000 vs 1001), invalid input?
- [ ] One reason to fail per test?

## 3. Code (3–5 min)
- [ ] Readable without explanation? Good names?
- [ ] No duplication that a table/loop/helper function would remove?
- [ ] Uses Kotlin idioms where they help readability (`when`, `require`, collection functions)? Don't push idioms where a loop is clearer.
- [ ] No leftover `println`, commented-out code, unused imports?

## How to comment

- Ask questions instead of giving the fix: *"What happens if the input is empty?"* rather than *"add `if (s.isEmpty()) return 0`"*.
- Mark comments: **must** (blocks merge) / **should** / **nit** (optional).
- Leave at least one positive comment on what she did well.
- Things she repeats across MRs → put them on the agenda for the weekly demo, not in another comment.

## Weekly demo agenda (30–45 min)

1. She shows the week's MRs and explains one solution out loud (10 min)
2. You ask "why" questions about one design choice (10 min)
3. Read `LEARNINGS.md` together; pick one open question to explain (10 min)
4. Agree on next week's goal (5 min)
