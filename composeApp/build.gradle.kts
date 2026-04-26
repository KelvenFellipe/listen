import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlin.plugin.serialization)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm()

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation("io.ktor:ktor-client-cio:3.3.0")
            implementation(libs.androidx.media3.exoplayer)
            implementation(libs.androidx.media3.exoplayer.dash)
            implementation(libs.androidx.media3.ui)
            implementation(libs.androidx.media3.ui.compose.material3)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(projects.shared)
            implementation(libs.coil3.coil.compose)
            implementation(libs.coil.network.okhttp)
            implementation(project.dependencies.platform("androidx.compose:compose-bom:2025.10.00"))
            implementation(libs.icons.lucide)
            implementation(project.dependencies.platform("io.github.jan-tennert.supabase:bom:3.2.5"))
            implementation(libs.postgrest.kt)
            implementation(libs.ktor.client.android)
            implementation(libs.gotrue.kt)
            implementation(libs.realtime.kt)
            implementation(project.dependencies.platform("io.github.jan-tennert.supabase:bom:3.2.5"))
            implementation(libs.supabase.postgrest.kt)
            implementation(libs.auth.kt)
            implementation(libs.supabase.realtime.kt)
            implementation(libs.kotlinx.datetime)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
            implementation("io.ktor:ktor-client-cio:3.3.0")
        }
    }
}

android {
    namespace = "com.github.kelvenfellipe.listen"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.github.kelvenfellipe.listen"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"

        }



        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
            }


        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11

            targetCompatibility = JavaVersion.VERSION_11
        }
    }

    dependencies {
        debugImplementation(compose.uiTooling)
        implementation("com.squareup.retrofit2:retrofit:3.0.0")
        implementation("com.squareup.retrofit2:converter-scalars:3.0.0")

    }
    compose.desktop {
        application {
            mainClass = "com.github.kelvenfellipe.listen.MainKt"

            nativeDistributions {
                targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = "com.github.kelvenfellipe.listen"
                packageVersion = "1.0.0"
            }
        }
    }
}
