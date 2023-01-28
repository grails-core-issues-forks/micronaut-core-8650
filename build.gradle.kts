plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.7.0"
}

version = "0.1"
group = "programmaticlogging"

repositories {
    mavenCentral()
    maven { setUrl("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")
    runtimeOnly("org.yaml:snakeyaml")
}

configurations.all {
    resolutionStrategy {
        force("org.slf4j:slf4j-api:2.0.4")
        force("ch.qos.logback:logback-classic:1.4.5")
        force("ch.qos.logback:logback-core:1.4.5")
    }
}


application {
    mainClass.set("example.micronaut.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
}



