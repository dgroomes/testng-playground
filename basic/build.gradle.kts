import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    java
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

val slf4jVersion = "1.7.36" // SLF4J releases: http://www.slf4j.org/news.html
val testNgVersion = "7.6.1" // TestNG releases: https://github.com/cbeust/testng/releases

dependencies {
    testImplementation("org.testng:testng:$testNgVersion")
    testImplementation("org.slf4j:slf4j-simple:$slf4jVersion")
}

tasks {

    test {
        useTestNG()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
            events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
         }
    }
}
