
plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.5.30"
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        resValue("string", "app_name", "CoinJet (debug)")

        buildConfigField("String", "baseUrl", "\"${Config.cryptoBaseUrl}\"")
        buildConfigField("String", "baseImageUrl", "\"${Config.cryptoBaseImageUrl}\"")
        buildConfigField("String", "apiKey", "\"${Config.apiKey}\"")
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".dev"
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false

            resValue("string", "app_name", "CoinJet (debug)")
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            resValue("string", "app_name", "CoinJet")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    kapt {
        correctErrorTypes = true
    }
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xjvm-default=all-compatibility"
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.2.0")
    implementation(kotlin("stdlib-jdk8"))
    /**
     * Compose
     */
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.animation)
    implementation(Dependencies.Compose.icons)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.lifecycleLiveData)
    implementation(Dependencies.Compose.lifecycleViewModel)
    implementation(Dependencies.Compose.lifecycleViewModelKtx)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.ripple)
    implementation(Dependencies.Compose.runtimeLiveData)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.accompanist)
    debugImplementation(Dependencies.Compose.tooling)
    androidTestImplementation(Dependencies.Compose.uiJUnit)
    /**
     * Navigation
     */
    implementation(Dependencies.Navigation.navigation)
    /**
     * Dagger2
     */
    implementation(Dependencies.Dagger2.dagger)
    implementation(Dependencies.Dagger2.daggerAndroidSupport)
    kapt(Dependencies.Dagger2.daggerCompiler)
    /**
     * Hilt
     */
    implementation(Dependencies.Hilt.hiltAndroid)
    implementation(Dependencies.Hilt.hiltNavigationCompose)
    implementation(Dependencies.Hilt.hiltNavigationFragment)
    kapt(Dependencies.Hilt.hiltCompiler)
    kapt(Dependencies.Hilt.androidHiltCompiler)
    /**
     * Retrofit
     */
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.okkHttp)
    implementation(Dependencies.Retrofit.converterGson)
    implementation(Dependencies.Retrofit.gson)
    implementation(Dependencies.Retrofit.interceptor)
    /**
     * Joda DateTime
     */
    implementation(Dependencies.Joda.joda)
    /**
     * Room
     */
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.paging)
    kapt(Dependencies.Room.compiler)
    /**
     * Coil
     */
    implementation(Dependencies.Coil.coil)
}