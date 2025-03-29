// 스프링 부트 플러그인, 의존성을 자동으로 관리하는 플러그인 설치
plugins {
    id("java")
    id("org.springframework.boot") version("3.2.2")
    id("io.spring.dependency-management") version("1.0.11.RELEASE")
}

group = "kr.hs.study"       // 지정한 그룹 이름
version = "1.0-RELEASE"

// 소스를 컴파일할 때 사용할 자바의 버전
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}


// 의존성을 받을 저장소 지정
repositories {
    mavenCentral()
}

// 필요한 기능의 의존성 입력
dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("com.h2database:h2")
}

tasks.test {
    useJUnitPlatform()
}