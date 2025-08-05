plugins {
    id("java")
    java
    checkstyle
}

group = "org.example"
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
tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "org.example.Main"
        )
    }
}
checkstyle {
    toolVersion = "10.26.1"

}
tasks.withType<Checkstyle> {
    reports {
        xml.required.set(false)
        html.required.set(true)
    }
}

