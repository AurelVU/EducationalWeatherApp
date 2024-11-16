import com.android.ide.common.resources.readResourcesPropertiesFile
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "ru.vsu.educational_weather_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.vsu.educational_weather_app"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            val projectProperties = Properties().apply {
                file("../api.properties").inputStream().use { fis ->
                    load(fis)
                }
            }
            buildConfigField(type = "String", name = "API_KEY", value = projectProperties["API_KEY"].toString())
        }
        debug {
            isMinifyEnabled = false
            val projectProperties = Properties().apply {
                file("../api.properties").inputStream().use { fis ->
                    load(fis)
                }
            }
            buildConfigField(type = "String", name = "API_KEY", value = projectProperties["API_KEY"].toString())
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.converter.gson)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

