plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.synth.partner"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.synth.partner"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        // Thêm client ID vào BuildConfig
        val androidClientId = project.property("androidClientId") as String
        val webClientId = project.property("webClientId") as String
        buildConfigField("String", "ANDROID_CLIENT_ID", "\"${androidClientId}\"")
        buildConfigField("String", "WEB_CLIENT_ID", "\"${webClientId}\"")
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
        buildConfig  = true // Bật BuildConfig
    }
}

dependencies {
//    Room

    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

//    Data store
    implementation(libs.androidx.datastore.preferences)


//    Hilt - Android Dependency Injection
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    // Hilt tích hợp với Jetpack Compose
    implementation (libs.androidx.hilt.navigation.compose)

//    Permission
    implementation(libs.accompanist.permissions)


//    One tap sign in with Google
    implementation(libs.onetapcompose)

//    Navigation
    implementation(libs.androidx.navigation.compose)

    //  Splash Screen
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.splashscreen)

    implementation (libs.androidx.activity)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.text.google.fonts)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}