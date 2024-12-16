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
        property("sonar.projectKey", "EmployeeManager")
        property("sonar.projectName", "EmployeeManager")
        property("sonar.sources", "src/main/java/com/atuyto")
        property("sonar.host.url", "https://condor-funky-completely.ngrok-free.app")
        property("sonar.token", "squ_69f986dd2782786dec9596bfd09b1de4c9dd6a76")
        property("sonar.java.binaries", file("build/classes/java/main/com/atuyto"))
        property("sonar.jacoco.reportPaths", "reports/jacoco/test/testExec.xml")
    }
}

