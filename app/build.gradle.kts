plugins {
    id("com.android.application")
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

    buildToolsVersion = Config.buildToolsVersion
    defaultConfig {
        applicationId = Config.groupId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

        versionCode = Config.versionCode
        versionName = Config.versionName

        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
            isDebuggable = true
            isMinifyEnabled = false
            multiDexEnabled = true
        }
        getByName("release") {
            //signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            isMinifyEnabled = false
            multiDexEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(Depends.Kotlin.Stdlib())

    // Project
    // → Search
    implementation(project(Depends.Module.UI.search))
    implementation(project(Depends.Module.Domain.search))
    implementation(project(Depends.Module.Data.search))

    // → Playlist
    implementation(project(Depends.Module.UI.playlist))
    implementation(project(Depends.Module.Domain.playlist))
    implementation(project(Depends.Module.Data.playlist))

    // → Favorite
    implementation(project(Depends.Module.UI.favorite))
    implementation(project(Depends.Module.Domain.favorite))
    implementation(project(Depends.Module.Data.favorite))

    // → Music
    implementation(project(Depends.Module.UI.music))
    implementation(project(Depends.Module.Domain.music))
    implementation(project(Depends.Module.Data.music))

    implementation(project(Depends.Module.commons))
    implementation(project(Depends.Module.core))

    // Base
    implementation(Depends.AndroidX.core())
    implementation(Depends.AndroidX.AppCompat())
    implementation(Depends.Android.MaterialComponents())
    testImplementation(Depends.JUnit())
    androidTestImplementation(Depends.AndroidX.JUnit())
    androidTestImplementation(Depends.AndroidX.Espresso())

    // Android
    implementation(Depends.Android.Multidex())

    // Android X
    implementation(Depends.AndroidX.Paging())
    implementation(Depends.AndroidX.ConstraintLayout())
    implementation(Depends.AndroidX.Fragment())
    implementation(Depends.AndroidX.SwipeRefreshLayout())
    implementation(Depends.AndroidX.CardView())
    implementation(Depends.AndroidX.RecyclerView())
    // → Lyfecycle
    implementation(Depends.AndroidX.Lyfecycle.LiveData())
    implementation(Depends.AndroidX.Lyfecycle.ViewModel())
    implementation(Depends.AndroidX.Lyfecycle.Extensions())
    // → Navigation
    implementation(Depends.AndroidX.Navigation.Fragment())
    implementation(Depends.AndroidX.Navigation.UI())

    // RxJava
    implementation(Depends.RxJava3.RxAndroid())
    implementation(Depends.RxJava3.RxJava())
    implementation(Depends.RxJava3.RxKotlin())

    // Dagger
    implementation(Depends.Dagger.core())
    kapt(Depends.Dagger.Compiler())
    implementation(Depends.Dagger.Android.core())
    implementation(Depends.Dagger.Android.Support())
    kapt(Depends.Dagger.Android.Support())
    kapt(Depends.Dagger.Android.Processor())

    // Retrofit
    implementation(Depends.Retrofit.core())
    implementation(Depends.Retrofit.Converter.Moshi())
    implementation(Depends.Retrofit.Adapter.RxJava3())
    implementation(Depends.Retrofit.Converter.Gson())

    // Others
    implementation(Depends.SLF4J())
    implementation(Depends.Logback())
    implementation(Depends.Timber())
    implementation(Depends.Stetho())
}
repositories {
    mavenCentral()
}