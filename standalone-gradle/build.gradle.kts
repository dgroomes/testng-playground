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

    /**
     * Build a jar file containing the compiled test classes.
     */
    register("testJar", Jar::class.java) {
        archiveFileName.set("test.jar")
        from(sourceSets["test"].output)
    }

    /**
     * Install everything.
     *
     * Copy all library files to a directory. In this particular meaning of the word "library" we're even including the
     * .jar file built from the application's main source code and the .jar file built from the application's test
     * source code.
     *
     * Partially gleaned from https://github.com/gradle/gradle/blob/e5de9e91f726af15eac246caff489d8a65112e35/subprojects/plugins/src/main/java/org/gradle/api/plugins/ApplicationPlugin.java#L217
     */
    register("install", Copy::class.java) {
        from(configurations.runtimeClasspath)
        from(configurations.testRuntimeClasspath)
        from(project.tasks.named("jar"))
        from(project.tasks.named("testJar"))
        into("${buildDir}/install/libs")
    }
}
