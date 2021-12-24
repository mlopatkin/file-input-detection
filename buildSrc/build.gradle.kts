import java.io.FileInputStream

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

val readFile = tasks.register("readFile") {
    doLast {
        // reading files when executing a task in buildSrc is explicitly allowed.
        FileInputStream(file("../undetected.txt")).use {
            println(String(it.readBytes()))
        }
    }
}

tasks.named("classes").configure {
    dependsOn(readFile)
}