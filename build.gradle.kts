plugins {
    java
    id("com.gradleup.shadow") version "9.3.2"
    id("io.github.intisy.github-gradle") version "1.8.2.1"
}

group = "io.github.thebusybiscuit"
description = "ChestTerminal is a Slimefun addon that adds a chest terminal item."

apply(from = "https://raw.githubusercontent.com/Slimefun5/gradle/stable/slimefun-addon.gradle")

dependencies {
<<<<<<< HEAD
    implementation("com.github.Slimefun5:SlimefunMetrics:master-SNAPSHOT")
<<<<<<< HEAD
    "githubCompileOnly"("Slimefun5:Slimefun5:v5.1.1")
    compileOnly("io.papermc.paper:paper-api:${property("paperApiVersion")}")
=======
=======
    githubImplementation("Slimefun5:SlimefunMetrics:v1.0.0")
<<<<<<< HEAD
>>>>>>> origin/experimental
=======
    implementation("org.bstats:bstats-bukkit:2.2.1")
<<<<<<< HEAD
>>>>>>> origin/experimental
    githubCompileOnly("Slimefun5:Slimefun5:gh-v5.2.3.2")
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
>>>>>>> origin/experimental
    compileOnly("com.google.code.findbugs:jsr305:3.0.2")
    
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.mockito:mockito-core:5.15.2")
    testImplementation("org.slf4j:slf4j-simple:2.0.16")
    testImplementation("org.mockbukkit.mockbukkit:mockbukkit-v1.21:4.107.0") {
        exclude(group = "org.jetbrains", module = "annotations")
    }
=======
>>>>>>> origin/experimental
}

tasks {
    shadowJar {
<<<<<<< HEAD
        archiveFileName.set("ChestTerminal v${project.version}.jar")
=======
        relocate("org.bstats", "chestterminal.libs.bstats")
<<<<<<< HEAD
<<<<<<< HEAD
        archiveFileName.set("ChestTerminal-1.0.0-UNOFFICIAL.jar")
>>>>>>> origin/experimental
=======
        archiveFileName.set("ChestTerminal-$displayVersion.jar")
>>>>>>> origin/experimental
                exclude("META-INF/**")
=======
>>>>>>> origin/experimental
    }
}
