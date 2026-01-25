# =========================
# Stage 1: Build
# =========================
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/banking-account-service-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=dev
ENV SERVER_SERVLET_CONTEXT_PATH=/api/accountservice
ENV URL_CORE=http://banking-core-simulation:8080/api/core-simulation/v1/gateway

EXPOSE 8082

ENTRYPOINT ["java","-jar","app.jar"]