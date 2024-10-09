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
//        compose = true
        viewBinding = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.1"
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val coreVer = "1.13.1"
    val lifecycleVer = "2.8.6"
    val compatVer = "1.7.0"
    val jUnitVer = "4.13.2"
    val jUnitExtVer = "1.2.1"
    val constraintLayoutVer = "2.1.4"

    val gsonVer = "2.10.1"          // https://mvnrepository.com/artifact/com.google.code.gson/gson

    val roomVer = "2.6.1"           // ksp support version 2.3.0
    val retrofitVer = "2.11.0"      // https://github.com/square/retrofit/releases/tag/2.11.0
    val glideVer = "4.14.2"         // ksp support version 4.14.0
    // val hiltVer = "2.48"
    val daggerVer = "2.49"          // Warning: Dagger’s KSP support is currently in alpha.-- https://dagger.dev/dev-guide/ksp
    val coroutinesVer = "1.9.0"

    val leakCanaryVer = "2.14"     // https://github.com/square/leakcanary/releases

    val materialVer = "1.12.0"
    val fireBaseBomVer = "33.4.0"
    val firebaseCrashlyticsVer = "19.1.0"
    val firebaseAnalyticsVer = "22.1.0"
    val loggerVer = "2.2.0"

    implementation("androidx.core:core-ktx:$coreVer")
    implementation("androidx.appcompat:appcompat:$compatVer") // 최신 버전 확인 후 수정
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVer")
    //kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycleVer")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVer")
    implementation("com.google.android.material:material:$materialVer")

    implementation ("androidx.constraintlayout:constraintlayout:$constraintLayoutVer")

    implementation("com.google.code.gson:gson:$gsonVer")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVer")
    implementation ("com.github.bumptech.glide:glide:$glideVer")

    implementation ("androidx.datastore:datastore-preferences:1.1.1")

    implementation("androidx.room:room-runtime:$roomVer")
    annotationProcessor("androidx.room:room-compiler:$roomVer")
    annotationProcessor("androidx.room:room-compiler:$roomVer")
    implementation ("androidx.room:room-paging:$roomVer")

    implementation("com.google.dagger:dagger:$daggerVer")
    annotationProcessor("com.google.dagger:dagger-compiler:$daggerVer")

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
    debugImplementation("com.squareup.leakcanary:leakcanary-android:$leakCanaryVer")
}