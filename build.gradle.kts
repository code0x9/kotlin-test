plugins {
    alias(libs.plugins.kotlin)
    application
}

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

application {
    mainClass = "com.mark.study.AppKt"
}
