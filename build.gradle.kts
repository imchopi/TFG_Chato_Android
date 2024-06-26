// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

plugins {
    id("com.google.gms.google-services") version "4.3.15" apply false
    id("org.jetbrains.dokka") version "1.9.20"
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("org.jetbrains.kotlin.kapt") version "2.0.0-Beta1" apply  false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}