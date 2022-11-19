# basic

A basic example of TestNG using Gradle.


## Instructions

Follow the below instructions to compile the source code and run the TestNG test suite.

1. Use Java 17  
2. Compile the code and run the tests
   * `./gradlew test`
   * Gradle makes it as easy as that! The results of the test suite will be printed to the terminal.


## Notes

Gradle's support for TestNG feels good so far. I'm able to run the basic test suite in this project. Unfortunately,
when I try to run the test suite in Intellij using a TestNG run configuration, Intellij's test runner isn't picking up
the classpath of the `basic.test` module. Specifically, the SLF4J dependency is missing from the classpath and I get
the familiar `SLF4J: Defaulting to no-operation (NOP) logger implementation` warning message. The test suite runs to
completion at least.


## Reference

* [TestNG official site](https://testng.org/doc/)
