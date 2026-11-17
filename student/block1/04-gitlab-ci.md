# 1.4 GitLab CI Pipeline (½–1 day)

From now on GitLab runs your tests automatically on every push. Your mentor only reviews
MRs with a **green pipeline**.

## Tasks

Branch: `ci`.

1. Create a `.gitlab-ci.yml` in the root of your repo with **one job** called `test` that:
   - runs in a Docker image with Maven and Java 21 (look for the official `maven` image
     on Docker Hub — ask your mentor if we must use an internal registry)
   - runs `mvn --batch-mode verify`
2. Push and watch the pipeline under *Build → Pipelines*. Read the job log.
3. **Cache** the Maven dependencies so the second run is faster.
   Hint: Maven's `-Dmaven.repo.local=...` option and GitLab's `cache:` keyword.
4. Publish the **test report** so test results appear in the MR.
   Hint: `artifacts: reports: junit:` and the files in `target/surefire-reports/`.
5. **Break it on purpose:** push a commit with a failing test. Check that the pipeline is
   red and the MR shows which test failed. Then fix it.
6. In the project settings, turn on *Merge requests → Pipelines must succeed*.

## Documentation

- https://docs.gitlab.com/ci/quick_start/
- https://docs.gitlab.com/ci/yaml/ (look up `image`, `script`, `cache`, `artifacts`)

## Done when

- [ ] The pipeline is green on `main`
- [ ] The second pipeline run is faster than the first (compare the job durations)
- [ ] The MR shows a test summary
- [ ] A red pipeline blocks merging

## Questions to answer in the MR description

1. Why `mvn verify` and not just `mvn test`?
2. What does `--batch-mode` change?
3. Where does the pipeline actually run — on your laptop, on the GitLab server, or somewhere else?
