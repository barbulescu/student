# 1.2 A Kotlin Maven Project From Scratch (1–2 days)

In real projects a generator (Spring Initializr, IntelliJ wizard) creates the `pom.xml`
for you. Before you use generators, you build one **by hand** so you understand
what they produce.

**Rule:** do not use IntelliJ's "New Project" wizard or copy a pom from the internet.
Start with an empty file and add one piece at a time. Reading documentation is allowed
and expected.

## Tasks

Work on a branch `maven-setup` in your `katas` repo.

1. Create this folder structure:
   ```
   katas/
   ├── pom.xml
   └── src/
       ├── main/kotlin/katas/hello/Hello.kt
       └── test/kotlin/katas/hello/HelloTest.kt
   ```
2. Write a `pom.xml` with:
   - `groupId` `com.example.katas`, `artifactId` `katas`, version `1.0-SNAPSHOT`
   - properties for the Kotlin version and the JUnit version (so they are defined once)
   - the Kotlin standard library as a dependency
   - JUnit Jupiter as a **test** dependency, version managed by the **JUnit BOM**
   - the `kotlin-maven-plugin` that compiles main and test code
   - the `maven-surefire-plugin` that runs the tests
   - source directories pointing to `src/main/kotlin` and `src/test/kotlin`
   - Java target: 21
3. `Hello.kt`: a function `fun greet(name: String): String` that returns `"Hello, <name>!"`.
4. `HelloTest.kt`: one JUnit test for `greet`.
5. Run from the **terminal**: `mvn test`. Then `mvn package`. Then `mvn clean`.
6. Open the project in IntelliJ (*File → Open → pom.xml → Open as Project*) and run the
   test with the green arrow.
7. Open an MR.

## Documentation

- Kotlin with Maven: https://kotlinlang.org/docs/maven.html
- JUnit user guide (Maven section): https://docs.junit.org/current/user-guide/
- Maven in 5 minutes: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
- Latest versions: search on https://central.sonatype.com

## Done when

- [ ] `mvn test` prints `Tests run: 1, Failures: 0` and `BUILD SUCCESS`
- [ ] Changing the expected value in the test makes `mvn test` fail (try it, then undo it)
- [ ] `target/` is **not** in Git
- [ ] The test runs in IntelliJ too

## Questions to answer in the MR description

1. What do `groupId`, `artifactId` and `version` mean? What does `SNAPSHOT` mean?
2. What does the JUnit BOM do, and why don't you need a `<version>` on `junit-jupiter`?
3. What does `<scope>test</scope>` mean? What would happen without it?
4. Name the Maven lifecycle phases between `validate` and `install`. Which ones run when you
   type `mvn package`?
5. Where on your machine does Maven store downloaded dependencies?
6. What is inside `target/` after `mvn package`?
