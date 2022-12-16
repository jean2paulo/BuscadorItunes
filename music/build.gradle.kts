plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Config.compileSdkVersion

    buildFeatures {
        dataBinding = false
        viewBinding = true
    }

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Project
    implementation(project(Depends.Module.commons))
    implementation(project(Depends.Module.core))

    // Base
    implementation(Depends.AndroidX.core())
    implementation(Depends.AndroidX.AppCompat())
    implementation(Depends.Android.MaterialComponents())
    testImplementation(Depends.JUnit())
    androidTestImplementation(Depends.AndroidX.JUnit())
    androidTestImplementation(Depends.AndroidX.Espresso())

}