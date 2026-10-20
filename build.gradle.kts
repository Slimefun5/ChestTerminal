plugins {
    java
    id("com.gradleup.shadow") version "9.3.2"
    id("io.github.intisy.github-gradle") version "1.8.2.1"
}

group = "io.github.thebusybiscuit"
description = "ChestTerminal is a Slimefun addon that adds a chest terminal item."

apply(from = "https://raw.githubusercontent.com/Slimefun5/gradle/main/slimefun-addon.gradle")

dependencies {
    implementation("org.bstats:bstats-bukkit:2.2.1")
}

tasks {
    shadowJar {
        relocate("org.bstats", "chestterminal.libs.bstats")
    }
}
