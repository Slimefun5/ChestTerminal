# ChestTerminal

[![Build Status](https://Slimefun5.github.io/builds/Slimefun5/ChestTerminal/stable/badge.svg)](https://Slimefun5.github.io/builds/Slimefun5/ChestTerminal/stable)
![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/Slimefun5/ChestTerminal/total)
[![GitHub Followers](https://img.shields.io/github/followers/Slimefun5?style=social)](https://github.com/Slimefun5)
[![GitHub Stars](https://img.shields.io/github/stars/Slimefun5/ChestTerminal?style=social)](https://github.com/Slimefun5/ChestTerminal)

A Slimefun addon that adds a chest terminal system for managing item networks.

## Requirements
- Java 25
- Paper 1.16.* - 26.1.*
- Slimefun 5

## Developer API

You can easily depend on this project using [github-gradle](https://github.com/intisy/github-gradle).

In your `build.gradle.kts`:

```kotlin
plugins {
    id("io.github.intisy.github-gradle") version "1.8.2.1"
}

dependencies {
    "githubCompileOnly"("Slimefun5:ChestTerminal:v1.1.1")
}
```


ChestTerminal is a [Slimefun5](https://github.com/Slimefun/Slimefun4) addon that is heavily inspired by the famous mod [Applied Energistics](https://www.curseforge.com/minecraft/mc-mods/applied-energistics-2).

It adds a Chest Terminal that you can hook up to a Cargo System to access all your items that are accessible through Cargo Nodes on the CT-Channel.

## ⚡ Requirements

- [Slimefun5](https://github.com/Slimefun/Slimefun4) (v5.0.0+)

## 🔧 Building

```bash
gradlew.bat build    # Windows
./gradlew build      # Linux/macOS
```

## ⚠️ Performance Notice

**Warning**: ChestTerminal can be very heavy on performance. This addon can cause quite a bit of lag, so make sure that you are aware of this when installing.

## 📖 Wiki

[Read more on the Slimefun Wiki...](https://github.com/Slimefun/Slimefun4/wiki/ChestTerminal)

## 💬 Discord

You can find Slimefun's community on Discord! Click the badge below to join the server for suggestions/questions or other discussions about this plugin.

<p align="center">
  <a href="https://discord.gg/fsD4Bkh">
  </a>
</p>

## 📜 License

This project is open-source and licensed under the [MIT License](https://github.com/TheBusyBiscuit/ChestTerminal/blob/master/LICENSE).
