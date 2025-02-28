plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.synth.partner"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.synth.partner"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "webClientId", "\"${project.findProperty("webClientId")}\"")
        }
        release {
            buildConfigField("String", "webClientId", "\"${project.findProperty("webClientId")}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    implementation("androidx.work:work-runtime-ktx:2.9.0")

    implementation(libs.androidx.hilt.work)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.firebase.firestore.ktx)
    // When using Kotlin.
    kapt(libs.androidx.hilt.compiler)


    implementation(libs.androidx.navigation.compose)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

//  dependency injection
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    implementation (libs.androidx.hilt.navigation.compose)

    // Google Play Services Auth (chứa GoogleSignIn)
    implementation ("com.google.android.gms:play-services-auth:21.3.0")


    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)


    //  Splash Screen
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.splashscreen)




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
// Allow references to generated code
kapt {
    correctErrorTypes = true
}


