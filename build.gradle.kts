// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply(from = "scripts/createfeature.gradle.kts")

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}
