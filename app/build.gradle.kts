import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
      id("com.android.application")
      id("org.jetbrains.kotlin.android")
      id ("kotlin-android")
      id ("kotlin-kapt")
      id ("dagger.hilt.android.plugin")
      id("com.google.gms.google-services")
}

android {
      namespace = "com.example.cashrecord"
      compileSdk = 34

      defaultConfig {
            applicationId = "com.example.cashrecord"
            minSdk = 26
            targetSdk = 33
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
      }

      buildTypes {
            release {
                  isMinifyEnabled = false
                  proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                  )
            }
      }
      compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
      }
      kotlinOptions {
            jvmTarget = "17"
      }
      buildFeatures {
            viewBinding = true;

      }
      sourceSets {
            getByName("main") {
                  assets {
                        srcDirs("src\\main\\assets", "src\\main\\assets")
                  }
            }
      }
}

dependencies {

      implementation("androidx.core:core-ktx:1.9.0")
      implementation("androidx.appcompat:appcompat:1.6.1")
      implementation("com.google.android.material:material:1.11.0")
      implementation("androidx.constraintlayout:constraintlayout:2.1.4")
      implementation("com.google.firebase:firebase-auth:22.3.0")
      testImplementation("junit:junit:4.13.2")
      androidTestImplementation("androidx.test.ext:junit:1.1.5")
      androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
      val hilt_version = "2.38.1"
      implementation("com.google.dagger:hilt-android:$hilt_version")
      kapt("com.google.dagger:hilt-compiler:$hilt_version")

      val lifecycle_version = "2.5.0-beta01"
      implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
      implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

      val retrofit_version = "2.9.0"
      implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
      implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")
      implementation("com.squareup.okhttp3:okhttp:4.9.3")

      val room_version = "2.4.2"
      implementation("androidx.room:room-runtime:$room_version")
      implementation("androidx.room:room-ktx:$room_version")
      kapt("androidx.room:room-compiler:$room_version")

      val coroutines_version = "1.6.0"
      implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
      implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

      val navigation_version = "2.4.2"
      implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
      implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")

      implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
      implementation("com.google.firebase:firebase-auth")

      val lottieVersion = "6.2.0"
      implementation ("com.airbnb.android:lottie:$lottieVersion")

}



      //implementation ("com.github.ybq:Android-SpinKit:1.4.0")


