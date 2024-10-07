plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.stver8935.riding"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.stver8935.riding"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {

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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val coreVer = "1.13.1"
    val lifecycleVer = "2.8.6"
    val composeVer = "1.9.2"
    val composeBomVer = "2024.09.03"
    val jUnitVer = "4.13.2"
    val jUnitExtVer = "1.2.1"

    val gsonVer = "2.10.1"          // https://mvnrepository.com/artifact/com.google.code.gson/gson

    val roomVer = "2.6.1"           // ksp support version 2.3.0
    val retrofitVer = "2.11.0"      // https://github.com/square/retrofit/releases/tag/2.11.0
    val glideVer = "4.14.2"         // ksp support version 4.14.0
    // val hiltVer = "2.48"
    val daggerVer = "2.49"          // Warning: Dagger’s KSP support is currently in alpha.-- https://dagger.dev/dev-guide/ksp
    val coroutinesVer = "1.9.0"

    val leakCanaryVer = "2.14"     // https://github.com/square/leakcanary/releases

    val fireBaseBomVer = "33.4.0"
    val firebaseCrashlyticsVer = "19.1.0"
    val firebaseAnalyticsVer = "22.1.0"
    val loggerVer = "2.2.0"

    implementation("androidx.core:core-ktx:$coreVer")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVer")
    //kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVer")

    implementation("androidx.activity:activity-compose:$composeVer")
    implementation(platform("androidx.compose:compose-bom:$composeBomVer"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    implementation("com.google.code.gson:gson:$gsonVer")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVer")
    ksp ("com.github.bumptech.glide:glide:$glideVer")

    implementation ("androidx.datastore:datastore-preferences:1.1.1")

    implementation("androidx.room:room-runtime:$roomVer")
    annotationProcessor("androidx.room:room-compiler:$roomVer")
    ksp ("androidx.room:room-compiler:$roomVer")
    implementation ("androidx.room:room-paging:$roomVer")

    implementation("com.google.dagger:dagger:$daggerVer")
    kapt("com.google.dagger:dagger-compiler:$daggerVer")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVer")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVer")

    implementation (platform("com.google.firebase:firebase-bom:$fireBaseBomVer"))
    implementation ("com.google.firebase:firebase-crashlytics-ktx:$firebaseCrashlyticsVer")
    implementation ("com.google.firebase:firebase-analytics-ktx:$firebaseAnalyticsVer")
    implementation ("com.orhanobut:logger:$loggerVer")


//    implementation ("com.google.dagger:hilt-android:$hiltVersion")
//    implementation ("com.google.dagger:hilt-compiler:$hiltVersion")

    testImplementation("junit:junit:$jUnitVer")
    androidTestImplementation("androidx.test.ext:junit:$jUnitExtVer")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:$composeBomVer"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVer")
}