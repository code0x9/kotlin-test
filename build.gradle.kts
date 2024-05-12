plugins {
  alias(libs.plugins.kotlin)
  application
}

sourceSets { main { resources { srcDirs("${projectDir}/template") } } }

kotlin { jvmToolchain(21) }

repositories { mavenCentral() }

application { mainClass = "com.mark.study.AppKt" }
