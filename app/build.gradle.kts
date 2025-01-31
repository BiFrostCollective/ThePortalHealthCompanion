plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // Required for Firebase
}
apply(plugin = "com.google.gms.google-services")

android {
    namespace = "com.example.theportalexperience"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.theportalexperience"
        minSdk = 23
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
        viewBinding = true
    }
}

dependencies {

    // Firebase dependencies

    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.mediarouter)
    implementation(libs.androidx.activity)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.androidx.camera.view)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.google.android.gms:play-services-auth:20.5.0") // Google Sign-In library
    implementation("androidx.appcompat:appcompat:1.7.0")

    // Google Sign-In
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    // ML Kit barcode scanning API
    implementation("com.google.mlkit:barcode-scanning:17.0.0")
    implementation("androidx.camera:camera-core:1.1.0-alpha08")
    implementation("androidx.camera:camera-camera2:1.1.0-alpha08")
    implementation("androidx.camera:camera-lifecycle:1.1.0-alpha08")

// CameraX API
    implementation("androidx.camera:camera-core:1.1.0-alpha08")
    implementation("androidx.camera:camera-camera2:1.1.0-alpha08")
    implementation("androidx.camera:camera-lifecycle:1.1.0-alpha08")

    // AndroidX dependencies
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
