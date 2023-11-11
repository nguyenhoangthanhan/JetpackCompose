plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.nguyenhoangthanhan.newsinshort"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nguyenhoangthanhan.newsinshort"
        minSdk = 24
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

//    implementation(libs.androidx.ktx)
//    implementation(libs.lifecycle.runtime.ktx)
//    implementation(libs.activity.compose)
//    implementation(platform(libs.compose.bom))
//    implementation(libs.ui)
//    implementation(libs.ui.graphics)
//    implementation(libs.ui.tooling.preview)
//    implementation(libs.material3)
//    implementation(libs.junit)
//    implementation(libs.androidx.test.ext.junit)
//    implementation(libs.espresso)
//    implementation(libs.ui.test.junit4)
//    implementation(libs.ui.tooling)
//    implementation(libs.ui.test.manifest)

    implementation(Dependencies.codeKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.uiGraphics)
    implementation(Dependencies.uiToolingPreview)
    implementation(Dependencies.material3)

    implementation(project(Modules.utilities))

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
}

kapt{
    correctErrorTypes = true
}