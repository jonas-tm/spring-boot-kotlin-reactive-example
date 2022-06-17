import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

val kotlin_version by extra { "1.7.0" }

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.springframework.experimental.aot") version "0.12.0" // includes spring native

	kotlin("jvm") version "1.7.0"
	kotlin("plugin.spring") version "1.7.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	maven { url = uri("https://repo.spring.io/release") }
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")

//	implementation("org.springframework.boot:spring-boot-starter-security")
//	runtimeOnly("org.postgresql:postgresql")
//	runtimeOnly("org.postgresql:r2dbc-postgresql")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.security:spring-security-test")

	// mocks
	testImplementation("io.mockk:mockk:1.12.4")
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

// Comment on for AOT when using spring boot run
//tasks.getByName<BootRun>("bootRun") {
//	systemProperty("springAot", "true")
//}

tasks.withType<BootBuildImage> {
	builder = "paketobuildpacks/builder:tiny"
	environment = mapOf("BP_NATIVE_IMAGE" to "true") // enable native image support
}
