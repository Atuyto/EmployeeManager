plugins {
    id("java")
    id("org.sonarqube") version "5.1.0.4882"
    id("jacoco")
}

group = "com.atuyto"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JacocoReport>("jacocoTestReport") {
    dependsOn(tasks.test) // Générer le rapport après les tests
    reports {
        xml.required = true
        html.required = true
    }
}

sonarqube  {
    properties {
        property("sonar.projectKey", "Atuyto-Fac-groupe_The-Rift-Mobile_53065491-1184-4c29-90c8-48ee261aa76f")
        property("sonar.projectName", "The-Rift-Mobile")
        property("sonar.organization", "Atuyto-Fac-groupe")
        property("sonar.sources", "src/main/java/main")
        property("sonar.host.url", "https://condor-funky-completely.ngrok-free.app")
        property("sonar.login", "squ_69f986dd2782786dec9596bfd09b1de4c9dd6a76")
        property("sonar.java.binaries", file("app/build/classes/java/debug"))
        property("sonar.jacoco.reportPaths", "app/reports/jacoco/test/testExec.xml")
    }
}
