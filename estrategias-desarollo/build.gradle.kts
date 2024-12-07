plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.crud"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot Starters
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	// Lombok
	implementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// MySQL Driver
	//implementation()
	runtimeOnly("mysql:mysql-connector-java:8.0.33")

	// DevTools (opcional, para reinicios automáticos en desarrollo)
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Test Dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
