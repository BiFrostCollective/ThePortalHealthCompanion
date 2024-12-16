plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.theportalexperience"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.theportalexperience"
        minSdk = 25
        targetSdk = 34
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
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.mediarouter)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Firebase SDKs
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-messaging")
    implementation("com.google.firebase:firebase-config")
    implementation("com.google.firebase:firebase-perf")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-predictions")

    // Google Fit SDK
    implementation("com.google.android.gms:play-services-fitness")

    // Health Connect SDK
    implementation("androidx.health.connect:health-connect-client:1.0.0")

    // Stripe SDK
    implementation("com.stripe:stripe-android:20.8.0")

    // Google Maps SDK
    implementation("com.google.android.gms:play-services-maps")

    // ML Kit SDKs for on-device machine learning
    implementation("com.google.mlkit:image-labeling:17.0.9")
    implementation("com.google.mlkit:text-recognition:16.0.1")

    // Firebase Realtime Database
    implementation("com.google.firebase:firebase-database")

    // Google Play In-App Billing
    implementation("com.android.billingclient:billing:7.1.1")

    // Google Places API
    implementation("com.google.android.gms:play-services-places:17.1.0")

    // Retrofit for Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Glide for Image Loading
    implementation("com.github.bumptech.glide:glide:4.15.0")

    // Room Database for Local Storage
    implementation("androidx.room:room-runtime:2.6.1")

    // Kotlin Coroutines for Asynchronous Programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Firebase App Distribution
    implementation("com.google.firebase:firebase-appdistribution")
}

// Apply Google Services Plugin
apply(plugin = "com.google.gms.google-services")