# Base image Java
FROM eclipse-temurin:21-jdk-alpine

# Working directory di container
WORKDIR /app

# Copy pom & sources
COPY pom.xml .
COPY src ./src

# Clean install + package
RUN mvn clean package -DskipTests

# Stage 2: Run jar
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy jar dari stage 1
COPY target/banking-account-service-0.0.1-SNAPSHOT.jar app.jar

# Set environment
ENV SPRING_PROFILES_ACTIVE=dev
ENV SERVER_SERVLET_CONTEXT_PATH=/api/accountservice

# Jalankan Spring Boot
ENTRYPOINT ["java","-jar","app.jar"]