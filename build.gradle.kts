plugins {
    java
    scala
    application
}

group = "ACM-hackerrank"
version = "1.0-SNAPSHOT"


val scalaVersion = "2.12"

repositories {
    mavenCentral()
}

application {
    mainClassName = "Main"
}


dependencies {
    compile("org.scala-lang", "scala-library", "$scalaVersion.6")
    compile("org.apache.kafka", "kafka-clients", "2.0.0")
    compile("com.typesafe.play", "play-json_$scalaVersion", "2.6.9")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.getByName<CreateStartScripts>("startScripts") {
    doLast {
        // 在脚本倒数第二行增加环境变量
        val lines = unixScript.readLines().toMutableList()
        lines.add(lines.size - 2, "export APP_HOME=\$APP_HOME")
        val newScript = lines.joinToString("\n")
        unixScript.delete()
        unixScript.createNewFile()
        unixScript.appendText(newScript)
    }
}