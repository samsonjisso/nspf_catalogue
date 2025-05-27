plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.samsonjisso.nspfcatalogue"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.samsonjisso.nspfcatalogue"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val room_version = "2.7.1"
    implementation("androidx.room:room-runtime:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    implementation("com.google.firebase:firebase-bom:33.14.0")
    implementation("com.google.firebase:firebase-analytics-ktx:22.4.0")
    implementation("com.google.firebase:firebase-firestore-ktx:25.1.4")

    implementation("io.coil-kt.coil3:coil-compose:3.2.0")

// Koin core features
    implementation("io.insert-koin:koin-android:4.0.4")
// Koin for Jetpack Compose
    implementation("io.insert-koin:koin-androidx-compose:4.0.4")
    // Koin for ViewModel
    implementation("io.insert-koin:koin-androidx-viewmodel:4.0.4")
    // Koin for Navigation
    implementation("io.insert-koin:koin-androidx-navigation:4.0.4")
    // Koin for WorkManager
    implementation("io.insert-koin:koin-androidx-workmanager:4.0.4")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}