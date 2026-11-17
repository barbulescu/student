# 1.1 Git & GitLab Check (½ day)

You already learned Git. This task checks that it works in our GitLab, with our tools.
Your mentor will watch the first 30 minutes — think out loud while you work.

## Tasks

1. **SSH key.** Create an SSH key (if you don't have one) and add it to your GitLab
   profile. Test it with `ssh -T git@<our-gitlab-host>`.
2. **Project.** Create a new, empty GitLab project called `katas` in your personal namespace.
   Add your mentor as a member with the *Maintainer* role.
3. **Clone** it via SSH into your work folder.
4. **First commit on `main`:** a `README.md` (one sentence: what this repo is) and a
   `.gitignore` that ignores Maven build output, IntelliJ files and macOS files.
   Find out yourself which files/folders these are.
5. **MR template.** Copy [../templates/merge_request_templates/Default.md](../templates/merge_request_templates/Default.md)
   to `.gitlab/merge_request_templates/Default.md` in your repo.
   Do this on a **branch** called `add-mr-template`, push it, and open a **merge request**.
6. Your mentor leaves a review comment. **Fix it with a new commit** on the same branch,
   push, and reply to the comment.
7. After approval: **merge** the MR in GitLab, then update your local `main` and
   delete the local branch.

## Commands you should be able to use without looking them up

`git status` · `git add` · `git commit` · `git log --oneline` · `git switch -c` ·
`git push -u origin <branch>` · `git pull` · `git branch -d` · `git diff`

## Done when

- [ ] `main` contains `README.md`, `.gitignore`, `.gitlab/merge_request_templates/Default.md`
- [ ] The MR shows two commits and an answered review comment
- [ ] `git status` on your machine is clean and you are on an up-to-date `main`

## Questions to answer in `LEARNINGS.md`

- What is the difference between `git fetch` and `git pull`?
- Why do we work on branches and not commit directly to `main`?
