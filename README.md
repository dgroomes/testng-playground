# testng-playground

📚 Learning and exploring TestNG <https://testng.org/doc/>.


## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:

### `basic/`

A basic example of TestNG using Gradle.

See the README in [basic/](basic/).

### `standalone-gradle/`

Build a standalone TestNG test suite that can be executed without Gradle. But build it with Gradle.

See the README in [standalone-gradle/](standalone-gradle/).


## Wish List

General clean-ups, changes and things I wish to implement for this project:

* [x] DONE Create a project that uses TestNG in a standalone way, ejecting from Gradle. This should be in a similar style as my
  [`standalone-gradle/` subproject in my `junit-playground` repository](https://github.com/dgroomes/junit-playground/tree/main/standalone-gradle).
  This is important because I think the ecosystem support for TestNG is generally poor and I need to be able to escape
  from these ecosystem tools like Gradle and Intellij because they don't work well with TestNG. I want to run TestNG
  "close to the metal" so to speak.
* [x] SKIPPED ([This StackOverflow answer](https://stackoverflow.com/a/30872987) solved the problem I had that motivated this wish list item) Implement a `@Factory` example
