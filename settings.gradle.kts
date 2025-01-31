@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    val kotlinVersion: String by settings
    val sqldelightVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        kotlin("native.cocoapods") version kotlinVersion
        id("com.squareup.sqldelight") version sqldelightVersion
        id("org.jlleitschuh.gradle.ktlint") version "10.1.0"
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.id == "android-gradle") {
                useModule("com.android.tools.build:gradle:7.0.2")
            }

            if (requested.id.id == "com.google.gms.google-services") {
                useModule("com.google.gms:google-services:4.3.10")
            }

            if (requested.id.id == "com.google.firebase.crashlytics") {
                useModule("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
            }
        }
    }
}


enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    val kotlinVersion: String by settings
    val sqldelightVersion: String by settings

    versionCatalogs {
        create("libs") {
            val kotlinRef = version("kotlin", kotlinVersion)
            val sqldelightRef = version("sqldelight", sqldelightVersion)
            val composeRef = version("compose", "1.0.2")
            val composeCompilerRef = version("compose-compiler", "1.1.0-alpha04")
            val composeActivityRef = version("composeActivity", "1.4.0-alpha02")
            val composeNavigationRef = version("composeNavigation", "2.4.0-alpha09")
            val coroutinesRef = version("kotlinx-coroutines", "1.5.2-native-mt")
            val datetimeRef = version("kotlinx-datetime", "0.3.0")
            val serializationRef = version("kotlinx-serialization", "1.2.1")
            val koinRef = version("koin", "3.1.2")
            val kermitRef = version("kermit", "0.1.9")
            val statelyRef = version("stately", "1.1.10")
            val ktorRef = version("ktor", "1.6.3")
            val multiplatformSettingsRef = version("multiplatformSettings", "0.8.1")
            val hyperdriveRef = version("hyperdrive", "0.1.110")
            val accompanistCoilRef = version("accompanistCoil", "0.13.0")
            val accompanistInsetsRef = version("accompanistInsets", "0.16.1")
            val coreRef = version("androidx-core", "1.6.0")
            val firebaseAnalyticsRef = version("firebase-analytics", "19.0.0")
            val uuidRef = version("uuid", "0.3.1")

            alias("kotlin-test-common").to("org.jetbrains.kotlin", "kotlin-test-common").versionRef(kotlinRef)

            alias("androidx-compose-ui-core").to("androidx.compose.ui", "ui").versionRef(composeRef)
            alias("androidx-compose-ui-tooling").to("androidx.compose.ui", "ui-tooling").versionRef(composeRef)
            alias("androidx-compose-foundation").to("androidx.compose.foundation", "foundation").versionRef(composeRef)
            alias("androidx-compose-material").to("androidx.compose.material", "material").versionRef(composeRef)
            alias("androidx-compose-activity").to("androidx.activity", "activity-compose").versionRef(composeActivityRef)
            alias("androidx-compose-navigation").to("androidx.navigation", "navigation-compose").versionRef(composeNavigationRef)

            alias("kotlinx-coroutines-core").to("org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef(coroutinesRef)
            alias("kotlinx-coroutines-android").to("org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef(coroutinesRef)
            alias("kotlinx-datetime").to("org.jetbrains.kotlinx", "kotlinx-datetime").versionRef(datetimeRef)

            alias("koin-core").to("io.insert-koin", "koin-core").versionRef(koinRef)
            alias("koin-android").to("io.insert-koin", "koin-android").versionRef(koinRef)
            alias("koin-test").to("io.insert-koin", "koin-test").versionRef(koinRef)

            alias("kermit").to("co.touchlab", "kermit").versionRef(kermitRef)
            alias("stately-common").to("co.touchlab", "stately-common").versionRef(statelyRef)

            alias("sqldelight-runtime").to("com.squareup.sqldelight", "runtime").versionRef(sqldelightRef)
            alias("sqldelight-coroutines").to("com.squareup.sqldelight", "coroutines-extensions").versionRef(sqldelightRef)
            alias("sqldelight-driver-ios").to("com.squareup.sqldelight", "native-driver").versionRef(sqldelightRef)
            alias("sqldelight-driver-android").to("com.squareup.sqldelight", "android-driver").versionRef(sqldelightRef)

            alias("ktor-client-core").to("io.ktor", "ktor-client-core").versionRef(ktorRef)
            alias("ktor-client-json").to("io.ktor", "ktor-client-json").versionRef(ktorRef)
            alias("ktor-client-logging").to("io.ktor", "ktor-client-logging").versionRef(ktorRef)
            alias("ktor-client-serialization").to("io.ktor", "ktor-client-serialization").versionRef(ktorRef)
            alias("ktor-client-okhttp").to("io.ktor", "ktor-client-okhttp").versionRef(ktorRef)
            alias("ktor-client-ios").to("io.ktor", "ktor-client-ios").versionRef(ktorRef)

            alias("multiplatformSettings-core").to("com.russhwolf", "multiplatform-settings").versionRef(multiplatformSettingsRef)
            alias("multiplatformSettings-test").to("com.russhwolf", "multiplatform-settings-test").versionRef(multiplatformSettingsRef)
            alias("accompanist-coil").to("com.google.accompanist", "accompanist-coil").versionRef(accompanistCoilRef)
            alias("accompanist-insets").to("com.google.accompanist", "accompanist-insets").versionRef(accompanistInsetsRef)

            alias("hyperdrive-multiplatformx-api").to("org.brightify.hyperdrive", "multiplatformx-api").versionRef(hyperdriveRef)

            alias("androidx-core").to("androidx.core", "core-ktx").versionRef(coreRef)

            alias("firebase-analytics").to("com.google.firebase", "firebase-analytics-ktx").versionRef(firebaseAnalyticsRef)

            alias("uuid").to("com.benasher44", "uuid").versionRef(uuidRef)

            bundle("androidx-compose", listOf(
                "androidx-compose-ui-core",
                "androidx-compose-ui-tooling",
                "androidx-compose-foundation",
                "androidx-compose-material",
                "androidx-compose-activity",
                "androidx-compose-navigation",
            ))
            bundle("ktor-common", listOf(
                "ktor-client-core",
                "ktor-client-json",
                "ktor-client-logging",
                "ktor-client-serialization",
            ))
            bundle("sqldelight-common", listOf(
                "sqldelight-runtime",
                "sqldelight-coroutines",
            ))
        }
    }
}

include(":shared", ":android", ":ios")
rootProject.name = "Droidcon"
