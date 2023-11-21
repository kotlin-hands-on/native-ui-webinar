import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.0"
    id("com.codingfeline.buildkonfig") version "0.15.0"
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-20"
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    sourceSets {
        all {
            languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
        }

        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation("io.ktor:ktor-client-core:2.3.3")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
            implementation("io.github.xxfast:kstore:0.6.0")
            implementation("io.github.xxfast:kstore-file:0.6.0")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
        }

        androidMain.dependencies {
            implementation("androidx.startup:startup-runtime:1.2.0-alpha02")
            implementation("io.ktor:ktor-client-android:2.3.3")
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.3")
        }
    }
}

android {
    namespace = "com.kmp.webinar.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

buildkonfig {
    packageName = "com.kmp.webinar"
    objectName = "ApiKeyConfig"
    exposeObjectWithName = "Config"

    defaultConfigs {
        buildConfigField(
            STRING,
            "WeatherApiKey",
            gradleLocalProperties(project.rootDir).getProperty("WEATHER_API_KEY")
        )
    }
}
