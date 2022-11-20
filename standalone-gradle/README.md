# standalone-gradle

Build a standalone TestNG test suite that can be executed without Gradle. But build it with Gradle.


## Description

Gradle is a powerful build tool. It is also used as a "test execution tool" and sometimes even as a general runner for
your programs using tasks like `./gradlew run`. But, sometimes we want to break free from Gradle and instead run our
programs directly. In this way, we want to use Gradle as a "build tool" but not as a "run tool". In this project in
particular, we want to use Gradle to download third party dependencies and then compile our Java source code. After that
is complete, we want to run the test suite using TestNG's own `main` method using a handwritten `java ...` command.


## Instructions

Follow the below instructions to build the program, create a runnable "escape hatch from Gradle", and run the TestNG
test suite.

1. Use Java 17  
2. Build and install the program and the tests:
   * ```shell
     ./gradlew install
     ```
3. Run the test suite (without Gradle!):
   * ```shell
     ./test.sh
     ```
   * It will look something like this:
     ```text
     ❯ ./test.sh
     [main] INFO org.testng.internal.Utils - [TestNG] Running:
       /private/var/folders/63/p1nrp8ks57zc1p7jsm2j_0dw0000gn/T/testngXmlPathInJar-1636653809446049810/testng.xml
     
     Hello from 'TheTest.thisWillFail()'
     Hello from 'TheTest.thisWillSucceed()'
     
     ===============================================
     MainSuite
     Total tests run: 2, Passes: 1, Failures: 1, Skips: 0
     ===============================================
     ```


## Reference

* [TestNG docs: *Running TestNG*](https://testng.org/doc/documentation-main.html#running-testng)
  * This section of the TestNG documentation describes how to run TestNG from the commandline using a `java ...` command.
