# Mentor Guide: Fundamentals, Blocks 1 & 2

Material for the first ~7 weeks (mid-November to mid-January).

## Folder layout

```
student/                 → give this to her (e.g. as a read-only GitLab repo "learning-path")
  README.md              → how we work: MR flow, 30-minute rule, weekly rhythm
  block1/                → 4 task sheets: Git check, Maven by hand, JUnit/FizzBuzz, GitLab CI
  block2/                → 5 katas; 1–3 have starter code with failing tests
  templates/             → MR template she copies into her repo

mentor/                  → keep this private
  reference-project/     → solution for block 1: pom.xml, FizzBuzz + tests, .gitlab-ci.yml
  kata-solutions/        → reference solutions for all katas + example tests for katas 4, 5, roman part 2
  review-checklist.md    → how to review an MR in 5–15 min + weekly demo agenda
  checkpoint-password-validator.md → unseen kata for the Block 2 exit check
```

All code is tested: Kotlin 2.4.21, JUnit 6.1.3, Java 21 target, Maven 3.9.
`cd mentor/kata-solutions && mvn test` runs the reference solutions.

## Schedule (3 office days/week)

| Week | Dates | She works on | Your time |
|---|---|---|---|
| 1 | Nov 17–20 | 1.1 Git check, 1.2 Maven by hand | **30 min live** for the Git check, then 1 MR review |
| 2 | Nov 23–27 | 1.3 FizzBuzz test-first, 1.4 GitLab CI | 2 MR reviews + demo |
| 3 | Nov 30–Dec 4 | Kata 1 Leap Year, Kata 2 String Calculator | 2 MR reviews + demo |
| 4 | Dec 7–11 | Kata 3 Roman Numerals (incl. part 2) | 1 MR review + demo |
| 5 | Dec 14–18 | Kata 4 Word Frequency (her own tests) | 1 MR review + demo |
| — | Dec 21–Jan 1 | Holidays | — |
| 6 | Jan 4–8 | Kata 5 Bank Account (her own tests) | 1 MR review + demo |
| 7 | Jan 11–15 | **Checkpoint**: password validator, alone, 1 day → then start Block 3 | 1 h assessment |

Expect about 2 h a week from you: 15 min kickoff, 2–3 × 15 min reviews, 30–45 min demo.

**If she's behind:** drop roman part 2 and the bank account bonus, but keep the
checkpoint. **If she's ahead:** give her the classic *Gilded Rose* refactoring kata.

## Before day 1 (about 30 min)

1. Check what she needs in GitLab: permission to create personal projects, a CI runner, and
   whether the `maven:3.9-eclipse-temurin-21` image is reachable or must come from
   the internal registry. Update `student/block1/04-gitlab-ci.md` if needed.
2. Replace `<our-gitlab-host>` in `student/block1/01-git-check.md`.
3. Put `student/` somewhere she can read it.

## Things to watch for

- **FizzBuzz difficulties.** In week 2 her commit history will show whether the problem
  was syntax or logic. If it was logic (e.g. checking 3 before 15), spend the demo
  on "how to order conditions". That gap matters more than any tool.
- **The given tests are a crutch on purpose.** They help in katas 1–3 and stop in kata 4.
  If kata 4 is a big struggle, do the first two tests together with her, then let her continue alone.
- **AI tools / copied solutions.** The katas are famous. The rule is in
  `student/block2/README.md`. Her commit history (small red→green steps) shows whether
  she actually did the work.
