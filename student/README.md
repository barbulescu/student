# Learning Path: Fundamentals (until March)

Goal: by March you can set up a Kotlin/Maven project on your own, write JUnit tests
*before* the code, and deliver every change through a GitLab merge request with a
green pipeline.

## Blocks

| Block | Weeks | Topic |
|---|---|---|
| 1 | 2 | Toolchain: Git check, Maven by hand, JUnit, GitLab CI |
| 2 | 3–4 | Problem solving test-first: 5 katas |

Blocks 3 (OOP project) and 4 (Spring Boot) follow in January.

## How we work

**One repository for all exercises.** You create a GitLab project called `katas` in block 1.
Every exercise after that is a **branch + merge request (MR)** in that repository.

**Every MR**
- has a green pipeline before you ask for review
- uses the MR template (what I did / what was hard / what I learned)
- is small: one exercise or one step per MR

**The 30-minute rule.** If you are stuck for 30 minutes, stop and write a question
in the MR or in chat. Include:
1. what you are trying to do
2. what you tried
3. what happened (error message, failing test output)

Writing that down often solves the problem by itself. If not, your mentor can answer
in 2 minutes instead of 20.

**Weekly rhythm**
- First office day: 15 min kickoff — agree on the goal for the week.
- During the week: work alone, open MRs, answer review comments.
- Last office day: 30–45 min demo — you show and explain what you built.

**Learning journal.** Keep a `LEARNINGS.md` in the root of your `katas` repo. Add one
or two lines every office day: something you learned, or something you still don't
understand. Commit it together with your work.

## Order

1. [block1/01-git-check.md](block1/01-git-check.md)
2. [block1/02-maven-from-scratch.md](block1/02-maven-from-scratch.md)
3. [block1/03-junit-fizzbuzz.md](block1/03-junit-fizzbuzz.md)
4. [block1/04-gitlab-ci.md](block1/04-gitlab-ci.md)
5. [block2/README.md](block2/README.md) — then the katas in numbered order
