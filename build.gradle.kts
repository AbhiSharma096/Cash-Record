// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
      id("com.android.application") version "8.1.0" apply false
      id("org.jetbrains.kotlin.android") version "1.8.0" apply false


}
buildscript {
      repositories {
            google()
            mavenCentral()
      }
      dependencies {
            classpath ("com.android.tools.build:gradle:7.0.4")
            classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
            classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
            classpath("com.google.gms:google-services:4.4.0")

            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
      }
}