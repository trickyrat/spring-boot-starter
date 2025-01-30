plugins {
    java
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
}


group = "com.trickyrat"
version = "0.0.1-SNAPSHOT"
description = "Spring Boot Starter"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

configurations {
    create("mybatisGenerator")
}

dependencies {
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // MyBatis
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:2.1.0")  
    runtimeOnly("com.mysql:mysql-connector-j:9.2.0")

    // MyBatis Generator
    "mybatisGenerator"("org.mybatis.generator:mybatis-generator-core:1.4.2")
    "mybatisGenerator"("com.mysql:mysql-connector-j:9.2.0")
    
    // Redis
    implementation("org.springframework.data:spring-data-redis:3.2.3")
    implementation("io.lettuce:lettuce-core:6.3.1.RELEASE")

    // OpenAPI
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.4")
}

tasks {
    register("mbGenerate", JavaExec::class) {
        group = "mybatis"
        classpath = configurations.getByName("mybatisGenerator")
        mainClass.set("org.mybatis.generator.api.ShellRunner")
        args(
            "-configfile", "${projectDir}/src/main/resources/generator/generatorConfig.xml",
            "-overwrite",
            "-verbose"
        )
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
