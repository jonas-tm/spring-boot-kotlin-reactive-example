import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.7.21" // also update plugin versions
val kotlin_serialization_version = "1.4.0"

plugins {
	id("org.springframework.boot") version "3.0.0-RC2"
	id("org.graalvm.buildtools.native") version "0.9.17"
	id("io.spring.dependency-management") version "1.1.0"

	kotlin("jvm") version "1.7.21"
	kotlin("plugin.spring") version "1.7.21"
	kotlin("plugin.serialization") version "1.7.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	maven { url = uri("https://repo.spring.io/release") }
	maven { url = uri("https://repo.spring.io/milestone") }
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlin_serialization_version")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")

	// Mocks
	testImplementation("io.mockk:mockk:1.12.8")
	testImplementation("com.ninja-squad:springmockk:3.1.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
