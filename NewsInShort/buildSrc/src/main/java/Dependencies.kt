object Dependencies {
    val appcompat by lazy { "androidx.appcompat:appcompat:${Version.appcompat}" }
    val codeKtx by lazy { "androidx.core:core-ktx:${Version.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}" }
    val lifecycleViewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}" }
    val lifecycleLivedataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}" }
    val lifecycleRuntimeCompose by lazy { "androidx.lifecycle:lifecycle-runtime-compose:${Version.lifecycle}" }
    val androidGradlePlugin by lazy { "androidx.core:core-ktx:${Version.androidGradlePlugin}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Version.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Version.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val uiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val uiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    val material3 by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Version.navigationVersion}" }
    val material by lazy { "com.google.android.material:material:${Version.material}" }
    val junit by lazy { "junit:junit:${Version.junit}" }
    val androidxTestExtJunit by lazy { "androidx.test.ext:junit:${Version.androidxTestExtJunit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Version.espresso}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Version.daggerHilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Version.daggerHilt}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Version.hiltCompiler}" }

    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Version.hiltCompiler}" }
}

object Modules {
    const val utilities = ":utilities"
}