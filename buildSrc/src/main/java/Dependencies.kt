
object Dependencies {
    object Compose {
        private const val lifecycleVersion = "2.5.1"
        private const val materialVersion = "1.3.1"
        private const val uiVersion = "1.3.2"

        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
        const val lifecycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val lifecycleViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
        const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:1.3.2"
        const val activity = "androidx.activity:activity-compose:1.6.1"
        const val ui = "androidx.compose.ui:ui:$uiVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$uiVersion"
        const val uiJUnit = "androidx.compose.ui:ui-test-junit4:$uiVersion"

        // Compose Material Design
        const val material = "androidx.compose.material:material:$materialVersion"
        const val ripple = "androidx.compose.material:material-ripple:$materialVersion"
        const val icons = "androidx.compose.material:material-icons-extended:$materialVersion"

        // Animations
        const val animation = "androidx.compose.animation:animation-core:$uiVersion"

        //Accompanist
        const val accompanist = "com.google.accompanist:accompanist-systemuicontroller:0.23.1"
    }

    object Navigation {
        private const val navVersion = "2.5.3"

        const val navigation = "androidx.navigation:navigation-compose:$navVersion"
    }

    object Dagger2 {
        private const val daggerVersion = "2.41"

        const val dagger = "com.google.dagger:dagger:$daggerVersion"
        const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Hilt {
        private const val googleHiltVersion = "2.44"
        private const val androidHiltVersion = "1.0.0"

        const val hiltAndroid = "com.google.dagger:hilt-android:$googleHiltVersion"
        const val hiltNavigationFragment = "androidx.hilt:hilt-navigation-fragment:$androidHiltVersion"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$androidHiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$googleHiltVersion"
        const val androidHiltCompiler = "androidx.hilt:hilt-compiler:$androidHiltVersion"
    }
    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        private const val okkHttpVersion = "4.9.0"

        const val gson = "com.google.code.gson:gson:$retrofitVersion"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val okkHttp = "com.squareup.okhttp3:okhttp:$okkHttpVersion"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$okkHttpVersion"
    }
    object Joda {
        private const val jodaVersion = "2.12.2"

        const val joda = "joda-time:joda-time:$jodaVersion"
    }
    object Room {
        private const val roomVersion = "2.4.3"

        const val ktx = "androidx.room:room-ktx:$roomVersion"
        const val runtime = "androidx.room:room-runtime:$roomVersion"